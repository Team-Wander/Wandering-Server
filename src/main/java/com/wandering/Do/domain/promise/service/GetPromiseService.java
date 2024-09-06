package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;

public interface GetPromiseService {

    PromiseGetRes execute(Long id);
}
