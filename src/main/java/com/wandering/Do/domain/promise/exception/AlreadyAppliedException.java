package com.wandering.Do.domain.promise.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class AlreadyAppliedException extends CustomException {
    public AlreadyAppliedException() {
        super(ErrorCode.ALREADY_APPLIED);
    }
}
