package com.wandering.Do.domain.admin.presentation;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.service.DeleteReportService;
import com.wandering.Do.domain.admin.service.GetReportInfoService;
import com.wandering.Do.domain.admin.service.GetReportListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final GetReportListService getReportListService;
    private final GetReportInfoService getReportInfoService;
    private final DeleteReportService deleteReportService;

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

    @DeleteMapping("/{dec_id}")
    public ResponseEntity<Void> deleteReport(@PathVariable("dec_id") Long id) {
        deleteReportService.execute(id);
        return ResponseEntity.noContent().build();
    }
}
