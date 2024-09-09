package com.wandering.Do.domain.promise.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class InvalidGradesSelectionException extends CustomException {
    public InvalidGradesSelectionException() {
        super(ErrorCode.INVALID_GRADES_SELECTION);
    }
}
