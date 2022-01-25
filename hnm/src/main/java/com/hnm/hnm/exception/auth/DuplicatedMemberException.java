package com.hnm.hnm.exception.auth;

import com.hnm.hnm.exception.CustomException;
import com.hnm.hnm.exception.ErrorCode;

public class DuplicatedMemberException extends CustomException {

    public DuplicatedMemberException() {
        super(ErrorCode.DUPLICATED_MEMBER_ERROR);
    }
}
