package com.infoshareacademy.api;

public class HolidayDateTime {
    private Integer year;
    private Integer month;
    private Integer day;

    public HolidayDateTime(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
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
        return "year: "
                + year
                + "\n"
                + "month: "
                + month + "\n"
                + "day: " + day;
    }
}
