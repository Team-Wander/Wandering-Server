package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.req.BoardWriteReq;

public interface WriteBoardService {

    void execute(BoardWriteReq writeReqDto);
}
