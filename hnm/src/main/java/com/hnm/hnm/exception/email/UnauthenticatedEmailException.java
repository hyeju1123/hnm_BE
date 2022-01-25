package com.hnm.hnm.exception.email;

import com.hnm.hnm.exception.CustomException;
import com.hnm.hnm.exception.ErrorCode;

public class UnauthenticatedEmailException extends CustomException {

    public UnauthenticatedEmailException() {
        super(ErrorCode.UNAUTHENTICATED_EMAIL_EXCEPTION);
    }
}
