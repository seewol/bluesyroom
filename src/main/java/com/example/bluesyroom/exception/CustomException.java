package com.example.bluesyroom.exception;

import com.example.bluesyroom.apiResponse.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 매개변수가 전부 있는 생성자
/* NoArgsConstructor : 기본 생성자
    만약 필요로 의한 생성자가 있다면 직접 만들어야 함 */
public class CustomException extends RuntimeException{

    private final ErrorCode errorCode;

}
