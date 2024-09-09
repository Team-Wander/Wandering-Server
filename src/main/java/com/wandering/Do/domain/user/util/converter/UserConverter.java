package com.wandering.Do.domain.user.util.converter;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.presentation.dto.res.GetListRes;

public interface UserConverter {
    GetListRes toListDto(Promise promise);
}
