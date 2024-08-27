package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.res.GetPromiseListResDto;

import java.util.List;

public interface GetBoardListService {

    List<GetPromiseListResDto> execute(String spot);
}
