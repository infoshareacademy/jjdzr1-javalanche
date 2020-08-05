package com.infoshareacademy.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilderingBuilder;

public class Country {
    private String id;
    private String name;

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "country id: "
                + id + "\n"
                + "name: " + name;
    }
}