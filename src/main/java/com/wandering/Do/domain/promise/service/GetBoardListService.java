package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.res.BoardGetListRes;

import java.util.List;

public interface GetBoardListService {

    List<BoardGetListRes> execute(String spot);
}
