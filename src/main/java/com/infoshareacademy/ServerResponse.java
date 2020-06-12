package com.infoshareacademy;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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

    // public List<Holidays> getHolidays() {
    //       return holidays;

    //1
    public List<Holidays> getHolidays() {
        List<Holidays> allHolidayList = new ArrayList<>();
        for (Holidays holidays : holidays) {

            allHolidayList.add(new Holidays(holidays.getName(), holidays.getDescription(), holidays.getCountry(),
                    holidays.getHolidayDate(), holidays.getType(), holidays.getLocations(), holidays.getStates()));
            allHolidayList.remove(holidays.getDescription());
            allHolidayList.remove(holidays.getCountry());
            allHolidayList.remove(holidays.getLocations());
            allHolidayList.remove(holidays.getStates());
        }
        return allHolidayList;

    }

}
