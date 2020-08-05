package com.infoshareacademy.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Holidays {
    private String name;
    private String description;
    private Country country;
    @SerializedName("date")
    @Expose
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

    public void setHolidayDate(HolidayDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HolidayDate getHolidayDate() {
        return holidayDate;
    }

    @Override
    public String toString() {
        return "name: "
                + name
                + "\n"
                + "description: "
                + description
                + "\n"
                + country.toString()
                + "\n"
                + holidayDate.toString()
                + "\n"
                + "type: "
                + type
                + "\n"
                + "locations: "
                + locations
                + "\n"
                + "states: "
                + states
                + "\n"
                + "\n";
    }
}
