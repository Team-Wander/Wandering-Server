package com.wandering.Do.domain.promise.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class InvalidDateException extends CustomException {
    public InvalidDateException() {
        super(ErrorCode.INVALID_DATE);
    }
}
