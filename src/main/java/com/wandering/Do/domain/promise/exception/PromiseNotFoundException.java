package com.wandering.Do.domain.promise.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class PromiseNotFoundException extends CustomException {
    public PromiseNotFoundException() {
        super(ErrorCode.PROMISE_NOT_FOUND);
    }
}
