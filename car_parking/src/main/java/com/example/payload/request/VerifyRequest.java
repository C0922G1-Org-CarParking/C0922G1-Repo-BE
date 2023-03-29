package com.example.payload.request;




public class VerifyRequest {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VerifyRequest() {
    }

    public VerifyRequest(String code) {
        this.code = code;
    }
}
