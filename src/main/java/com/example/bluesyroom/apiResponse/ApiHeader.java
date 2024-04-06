package com.example.bluesyroom.apiResponse;

public class ApiHeader {
    private int resultCode; // 성공 200, 실패다 999, 600
    private String  codeName; // success, fail, NOT_FOUND_USER

    public ApiHeader(int resultCode, String codeName) {
        this.resultCode = resultCode;
        this.codeName = codeName;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getCodeName() {
        return codeName;
    }

}
