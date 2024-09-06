package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;

public interface WritePromiseService {

    void execute(PromiseWriteReq writeReqDto);
}
