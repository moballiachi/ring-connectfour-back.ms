package com.ring.connectfour.crosscutting.error;

public class ConnectFourError extends Throwable implements BaseError{

    private String code;

    public ConnectFourError(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
