package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;

public interface WriteBoardService {

    void execute(PromiseWriteReq writeReqDto);
}
