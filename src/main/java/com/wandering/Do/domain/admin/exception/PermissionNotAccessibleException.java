package com.wandering.Do.domain.admin.exception;

import com.wandering.Do.global.exception.CustomException;
import com.wandering.Do.global.exception.ErrorCode;

public class PermissionNotAccessibleException extends CustomException {
    public PermissionNotAccessibleException() {
        super(ErrorCode.PERMISSION_NOT_ACCESSIBLE);
    }
}
