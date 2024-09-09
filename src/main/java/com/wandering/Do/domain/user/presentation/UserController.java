package com.wandering.Do.domain.user.presentation;

import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.user.service.getMyPromiseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my")
public class UserController {
    private final getMyPromiseService getMyPromiseService;
    @GetMapping
    public List<PromiseGetListRes> getMy() {
        return getMyPromiseService.execute();
    }
}
