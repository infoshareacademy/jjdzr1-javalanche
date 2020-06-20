package com.infoshareacademy.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HolidayDateTime {
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("month")
    @Expose
    private Integer month;
    @SerializedName("day")
    @Expose
    private Integer day;

    public HolidayDateTime(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "year: " + year + "\n" + "month: " + month + "\n" + "day: " + day;
    }
}
