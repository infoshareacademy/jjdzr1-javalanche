package com.infoshareacademy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HolidayDate {
    @SerializedName("iso")
    @Expose
    private String iso;
    @SerializedName("datetime")
    @Expose
    private HolidayDateTime holidayDateTime;

    public HolidayDate(String iso, HolidayDateTime holidayDateTime) {
        this.iso = iso;
        this.holidayDateTime = holidayDateTime;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public void setHolidayDateTime(HolidayDateTime holidayDateTime) {
        this.holidayDateTime = holidayDateTime;
    }

    public String getIso() {
        return iso;
    }

    public HolidayDateTime getHolidayDateTime() {
        return holidayDateTime;
    }

    @Override
    public String toString() {
        return "date iso: " + iso + "\n" + holidayDateTime.toString();
    }
}
