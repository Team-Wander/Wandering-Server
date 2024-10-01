package com.wandering.Do.domain.user.util.converter;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.presentation.dto.res.GetUserPromiseListRes;
import com.wandering.Do.domain.user.presentation.dto.res.GetWhoApplyPromiseRes;

public interface UserConverter {
    GetUserPromiseListRes toListDto(Promise promise);

    GetWhoApplyPromiseRes toDto(User user);
}
