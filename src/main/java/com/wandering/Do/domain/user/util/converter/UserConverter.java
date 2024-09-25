package com.wandering.Do.domain.user.util.converter;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;

public interface UserConverter {
    GetUserPromiseListRes toListDto(Promise promise);
}
