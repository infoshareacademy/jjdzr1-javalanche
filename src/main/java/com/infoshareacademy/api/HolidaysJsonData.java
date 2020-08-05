package com.infoshareacademy.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HolidaysJsonData {
    @SerializedName("meta")
    @Expose
    private ServerInfo serverInfo;
    @SerializedName("response")
    @Expose
    private ServerResponse serverResponse;

    public HolidaysJsonData() {
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    @Override
    public String toString() {
        return "Server info: "
                + serverInfo.toString()
                + "\n";
    }

    public static HolidaysJsonData readDataFromJsonFile() {
        Gson gson = new Gson();
        HolidaysJsonData holidaysJSONData = new HolidaysJsonData();
        try (Reader reader1 = new FileReader("src/main/resources/db_holidaysNational.json")) {
            holidaysJSONData = gson.fromJson(reader1, HolidaysJsonData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return holidaysJSONData;
    }
}

