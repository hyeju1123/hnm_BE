package com.hnm.hnm.exception.email;

import com.hnm.hnm.exception.CustomException;
import com.hnm.hnm.exception.ErrorCode;

public class NotFoundEmailTokenException extends CustomException {

    public NotFoundEmailTokenException() {
        super(ErrorCode.NOT_FOUND_EMAIL_TOKEN);
    }
}
