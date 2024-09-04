package com.wandering.Do.domain.promise.util;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.user.entity.User;

public interface PromiseConverter {
    Promise toEntity (PromiseWriteReq promiseWriteReq, User user);

    PromiseGetListRes toListDto (Promise promise);

    PromiseGetRes toDto (Promise promise);
}
