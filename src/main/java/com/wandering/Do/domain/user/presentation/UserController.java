package com.wandering.Do.domain.user.presentation;

import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;
import com.wandering.Do.domain.user.presentation.dto.res.GetWhoApplyPromiseRes;
import com.wandering.Do.domain.user.service.DeleteApplyPromiseService;
import com.wandering.Do.domain.user.service.GetMyApplyService;
import com.wandering.Do.domain.user.service.GetMyPromiseService;
import com.wandering.Do.domain.user.service.GetWhoApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my")
public class UserController {
    private final GetMyPromiseService getMyPromiseService;
    private final GetMyApplyService getMyApplyService;
    private final GetWhoApplyService getWhoApplyService;
    private final DeleteApplyPromiseService deleteApplyPromiseService;
    @GetMapping
    public ResponseEntity<List<GetUserPromiseListRes>> getMy() {
        List<GetUserPromiseListRes> res = getMyPromiseService.execute();
        return ResponseEntity.ok(res);
    }
    @GetMapping("/reservation")
    public ResponseEntity<List<GetUserPromiseListRes>> getMyApply() {
        List<GetUserPromiseListRes> res = getMyApplyService.execute();
        return ResponseEntity.ok(res);
    }
    @GetMapping("/{pro_id}/info")
    public ResponseEntity<List<GetWhoApplyPromiseRes>> getWhoApply(@PathVariable("pro_id") Long id) {
        List<GetWhoApplyPromiseRes> res = getWhoApplyService.execute(id);
        return ResponseEntity.ok(res);
    }
    @DeleteMapping("/{pro_id}")
    public ResponseEntity<Void> deleteApplyPromise(@PathVariable("pro_id")Long id) {
        deleteApplyPromiseService.execute(id);
        return ResponseEntity.noContent().build();
    }
}
