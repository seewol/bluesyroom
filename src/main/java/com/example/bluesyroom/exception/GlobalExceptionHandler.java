package com.example.bluesyroom.exception;

import com.example.bluesyroom.apiResponse.ApiBody;
import com.example.bluesyroom.apiResponse.ApiHeader;
import com.example.bluesyroom.apiResponse.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.bluesyroom.apiResponse.ErrorCode.INTERNAL_SERVER_ERROR;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ CustomException.class })
    protected <T> ApiResponse<T> handleCustomException(CustomException ex) {

        return new ApiResponse(new ApiHeader(ex.getErrorCode().getCode(), ex.getErrorCode().name()), new ApiBody(null, ex.getErrorCode().getMessage()));
        //return new ResponseEntity(new ErrorDto(ex.getErrorCode().getStatus(), ex.getErrorCode().getMessage()), HttpStatus.valueOf(ex.getErrorCode().getStatus()));

    }

    @ExceptionHandler({ Exception.class }) // CustomException이 잡지 못하는 에러 해결을 위해
    protected <T> ApiResponse<T> handleServerException(Exception ex) {
        return new ApiResponse(new ApiHeader(INTERNAL_SERVER_ERROR.getCode(), INTERNAL_SERVER_ERROR.name()), new ApiBody(null, INTERNAL_SERVER_ERROR.getMessage()));
        // return new ResponseEntity(new ErrorDto(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
