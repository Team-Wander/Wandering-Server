package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.req.PromiseUpdateReq;

public interface UpdatePromiseService {
    void execute(Long id, PromiseUpdateReq updateReqDto);
}
