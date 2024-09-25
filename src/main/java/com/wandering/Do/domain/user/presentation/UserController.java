package com.wandering.Do.domain.user.presentation;

import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;
import com.wandering.Do.domain.user.service.GetMyPromiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my")
public class UserController {
    private final GetMyPromiseService getMyPromiseService;
    @GetMapping
    public ResponseEntity<List<GetUserPromiseListRes>> getMy() {
        List<GetUserPromiseListRes> res = getMyPromiseService.execute();
        return ResponseEntity.ok(res);
    }
}
