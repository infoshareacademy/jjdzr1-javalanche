package com.infoshareacademy.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ServerResponse {
    @SerializedName("holidays")
    @Expose
    private List<Holidays> holidays;

    public ServerResponse(List<Holidays> holidays) {
        this.holidays = holidays;
    }

    public List<Holidays> getHolidays() {
        return holidays;
    }
}
