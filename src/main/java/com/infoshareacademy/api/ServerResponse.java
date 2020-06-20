package com.infoshareacademy.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ServerResponse {
    @SerializedName("holidays")
    @Expose
    private List<Holidays> holidays;

    public ServerResponse(List<Holidays> holidays) {
        this.holidays = holidays;
    }

    public void setHolidays(List<Holidays> holidays) {
        this.holidays = holidays;
    }

    public List<Holidays> getHolidays() {
        return holidays;
    }
}
