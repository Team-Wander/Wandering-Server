package com.wandering.Do.domain.user.service;

import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;

import java.util.List;

public interface GetMyApplyService {
    List<GetUserPromiseListRes> execute();
}
