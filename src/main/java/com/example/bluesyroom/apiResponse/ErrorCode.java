package com.example.bluesyroom.apiResponse;

public enum ErrorCode {
    /*FAIL(999, "실패"),
    NOT_SUPPORTED_METHOD(998, "NOT_SUPPORTED_METHOD"),
    NOT_FOUND_USER(100, "NOT_FOUND_USER"),
    NOT_FOUND_TOKEN(101, "NOT_FOUND_TOKEN"),
    MALFORMED_ERROR(102, "MALFORMED_ERROR"), */

    USER_DUPLICATE_ID(100, "중복된 아이디입니다."),
    USER_WRONG_PW(110, "잘못된 비밀번호입니다."),
    INTERNAL_SERVER_ERROR(500, "SERVER_ERROR")
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
