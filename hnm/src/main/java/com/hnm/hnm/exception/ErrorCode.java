package com.hnm.hnm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "페이지를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류입니다."),
    DUPLICATED_MEMBER_ERROR(HttpStatus.FORBIDDEN, "DUPLICATED_MEMBER_ERROR"),
    NOT_FOUND_EMAIL_TOKEN(HttpStatus.NOT_FOUND, "NOT_FOUND_EMAIL_TOKEN"),
    UNAUTHENTICATED_EMAIL_EXCEPTION(HttpStatus.UNAUTHORIZED, "UNAUTHENTICATED_EMAIL_EXCEPTION")
    ;

    private final HttpStatus status;
    private final String message;
}
