package com.wandering.Do.domain.promise.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class NotMatchUserException extends CustomException {
    public NotMatchUserException() {
        super(ErrorCode.NOT_MATCH_USER);
    }
}
