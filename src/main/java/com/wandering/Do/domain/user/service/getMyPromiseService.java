package com.wandering.Do.domain.user.service;

import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.presentation.dto.res.GetListRes;

import java.util.List;

public interface getMyPromiseService {
    List<GetListRes> execute();
}
