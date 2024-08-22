package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReqDto;

public interface WriteBoardService {

    void execute(PromiseWriteReqDto writeReqDto);
}
