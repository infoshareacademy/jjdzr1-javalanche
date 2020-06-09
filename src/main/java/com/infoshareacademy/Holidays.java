package com.infoshareacademy;

import java.util.List;

public class Holidays {
    private String name;
    private String description;
    private Country country;
    private HolidayDate holidayDate;
    private List<String> type;
    private String locations;
    private String states;

    public Holidays(String name, String description, Country country, HolidayDate holidayDate, List<String> type, String locations, String states) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.holidayDate = holidayDate;
        this.type = type;
        this.locations = locations;
        this.states = states;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setHolidayDate(HolidayDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Country getCountry() {
        return country;
    }

    public HolidayDate getHolidayDate() {
        return holidayDate;
    }

    public List<String> getType() {
        return type;
    }

    public String getLocations() {
        return locations;
    }

    public String getStates() {
        return states;
    }
}
