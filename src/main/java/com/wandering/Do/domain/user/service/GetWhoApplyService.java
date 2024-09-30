package com.wandering.Do.domain.user.service;

import com.wandering.Do.domain.user.presentation.dto.res.GetWhoApplyPromiseRes;

import java.util.List;

public interface GetWhoApplyService {
    List<GetWhoApplyPromiseRes> execute(Long promiseId);
}
