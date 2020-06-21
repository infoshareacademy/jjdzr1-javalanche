package com.infoshareacademy.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerInfo {
    @SerializedName("code")
    @Expose
    private Integer code;

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public ServerInfo(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
