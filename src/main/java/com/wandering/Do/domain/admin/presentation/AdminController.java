package com.wandering.Do.domain.admin.presentation;

import com.wandering.Do.domain.admin.presentation.dto.req.ChangeUserCase;
import com.wandering.Do.domain.admin.presentation.dto.res.SearchUserInfoRes;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.presentation.dto.res.UserListRes;
import com.wandering.Do.domain.admin.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final GetReportListService getReportListService;
    private final GetReportInfoService getReportInfoService;
    private final DeleteReportService deleteReportService;
    private final GetUserListService getUserListService;
    private final SearchUserInfoService findUserInfoService;
    private final ChangeUserCaseService changeUserCaseService;

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

    @GetMapping("/user_info")
    public ResponseEntity<List<UserListRes>> getUserList() {
        List<UserListRes> res = getUserListService.execute();
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<SearchUserInfoRes>> searchUser(@RequestParam String name) {
        List<SearchUserInfoRes> res = findUserInfoService.execute(name);
        return ResponseEntity.ok(res);
    }

    @PatchMapping("/{user_id}")
    public ResponseEntity<Void> changeUserCase(
            @PathVariable("user_id") UUID id,
            @RequestBody ChangeUserCase changeUserCase
    ) {
        changeUserCaseService.execute(id,changeUserCase);
        return ResponseEntity.noContent().build();
    }
}
