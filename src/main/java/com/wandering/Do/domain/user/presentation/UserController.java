package com.wandering.Do.domain.user.presentation;

import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;
import com.wandering.Do.domain.user.presentation.dto.res.GetWhoApplyPromiseRes;
import com.wandering.Do.domain.user.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my")
public class UserController {
    private final GetMyPromiseService getMyPromiseService;
    private final GetMyApplyService getMyApplyService;
    private final GetWhoApplyService getWhoApplyService;
    private final DeleteApplyPromiseService deleteApplyPromiseService;
    private final DeleteApplicantsService deleteApplicantsService;
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
    @DeleteMapping("/{pro_id}/{user_id}")
    public ResponseEntity<Void> deleteApplicants(@PathVariable("pro_id")Long pro_id,
                                                 @PathVariable("user_id")UUID user_id) {
        deleteApplicantsService.execute(pro_id, user_id);
        return ResponseEntity.noContent().build();
    }
}
