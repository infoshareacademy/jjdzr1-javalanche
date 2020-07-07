package com.infoshareacademy.api;

public class ServerInfo {

    private Integer code;

    public ServerInfo(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
