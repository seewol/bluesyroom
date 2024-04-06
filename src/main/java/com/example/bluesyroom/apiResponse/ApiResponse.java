package com.example.bluesyroom.apiResponse;

import lombok.Getter;

@Getter
public class ApiResponse<T>{
    private ApiHeader header;

    private ApiBody body;

    private static int SUCCESS = 200;

    public ApiResponse(ApiHeader header, ApiBody body) {
        this.header = header;
        this.body = body;

    }

    public ApiResponse(ApiHeader header) {
        this.header = header;

    }

    public static <T> ApiResponse<T> OK(T data) {
        return new ApiResponse<T>(new ApiHeader(SUCCESS, "SUCCESS"), new ApiBody(data,null));
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode) {
        return new ApiResponse(new ApiHeader(errorCode.getCode(), errorCode.name()), new ApiBody(null, errorCode.getMessage()));
    }
}
