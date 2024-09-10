package com.wandering.Do.domain.admin.presentation;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.service.GetReportInfoService;
import com.wandering.Do.domain.admin.service.GetReportListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final GetReportListService getReportListService;
    private final GetReportInfoService getReportInfoService;

    @GetMapping("/dec_info")
    public ResponseEntity<List<ReportListRes>> getReportList() {
        List<ReportListRes> res = getReportListService.execute();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{dec_id}")
    public ResponseEntity<ReportInfoRes> getReportInfo(@PathVariable("dec_id") Long id) {
        ReportInfoRes res = getReportInfoService.execute(id);
        return ResponseEntity.ok(res);
    }
}
