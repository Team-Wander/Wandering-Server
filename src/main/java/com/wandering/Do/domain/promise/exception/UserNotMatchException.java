package com.wandering.Do.domain.promise.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class UserNotMatchException extends CustomException {
    public UserNotMatchException() {
        super(ErrorCode.USER_NOT_MATCH);
    }
}
