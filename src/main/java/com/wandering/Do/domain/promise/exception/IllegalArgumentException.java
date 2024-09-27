package com.wandering.Do.domain.promise.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;

public class IllegalArgumentException extends CustomException {
    public IllegalArgumentException() {
        super(ErrorCode.ILLEGAL_ARGUMENT);
    }
}
