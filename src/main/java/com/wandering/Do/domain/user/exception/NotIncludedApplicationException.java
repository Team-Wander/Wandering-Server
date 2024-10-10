package com.wandering.Do.domain.user.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class NotIncludedApplicationException extends CustomException {

    public NotIncludedApplicationException() {
        super(ErrorCode.NOT_INCLUDED_APPLICATION);
    }
}
