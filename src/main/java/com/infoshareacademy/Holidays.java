package com.infoshareacademy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Holidays {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("date")
    @Expose
    private HolidayDate holidayDate;
    @SerializedName("type")
    @Expose
    private List<String> type = null;
    @SerializedName("locations")
    @Expose
    private String locations;
    @SerializedName("states")
    @Expose
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

    @Override
    public String toString() {
        return "name: " + name + "\n" + "description: " + description + "\n" + country.toString() + "\n" + holidayDate.toString() + "\n" + "type: " + type + "\n" + "locations: " + locations + "\n" + "states: " + states + "\n" + "\n";
    }
}
