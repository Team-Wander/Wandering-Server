package com.wandering.Do.domain.declare.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class NotEmptyReasonException extends CustomException {
    public NotEmptyReasonException() {
        super(ErrorCode.NOT_EMPTY_REASON);
    }
}
