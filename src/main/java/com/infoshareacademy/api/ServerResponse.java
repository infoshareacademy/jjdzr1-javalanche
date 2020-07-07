package com.infoshareacademy.api;

import java.util.List;

public class ServerResponse {

    private List<Holidays> holidays;

    public ServerResponse(List<Holidays> holidays) {
        this.holidays = holidays;
    }

    public List<Holidays> getHolidays() {
        return holidays;
    }
}
