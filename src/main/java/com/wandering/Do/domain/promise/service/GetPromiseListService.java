package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;

import java.util.List;

public interface GetPromiseListService {

    List<PromiseGetListRes> execute(String spot);
}
