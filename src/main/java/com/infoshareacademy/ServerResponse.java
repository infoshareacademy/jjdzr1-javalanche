package com.infoshareacademy;

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

    public static List<Holidays> getHolidays1(HolidaysJsonData holidaysJsonData) {
        List<Holidays> allHolidayList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            allHolidayList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
        }
        System.out.println(allHolidayList);
        return allHolidayList;
    }

}
