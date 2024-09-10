package com.wandering.Do.domain.admin.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class NotFoundReportException extends CustomException {
    public NotFoundReportException() {
        super(ErrorCode.NOT_FOUND_REPORT);
    }
}
