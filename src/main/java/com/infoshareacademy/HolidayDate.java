package com.infoshareacademy;

public class HolidayDate {
    private String iso;
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
}
