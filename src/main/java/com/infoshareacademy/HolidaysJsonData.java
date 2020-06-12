package com.infoshareacademy;

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

    public HolidaysJsonData(ServerInfo serverInfo, ServerResponse serverResponse) {
        this.serverInfo = serverInfo;
        this.serverResponse = serverResponse;
    }

    public void setServerInfo(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    public void setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    @Override
    public String toString() {
        return "Server info: " + serverInfo.toString() + "\n";
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

    public List<Holidays> printAllHolidays() throws IOException {

        //2.
//        HolidaysJsonData holidaysJsonData = new HolidaysJsonData();
//        Reader fileReader = new FileReader("src/main/resources/db_holidaysNational1.json");
//        Type holidayListType = new TypeToken<ArrayList<Holidays>>() {
//        }.getType();
//        List<Holidays> holidaysArray = new Gson().fromJson(fileReader, holidayListType);
//        return holidaysArray;

        //3.
        HolidaysJsonData jsonData = new HolidaysJsonData();

        Gson gson = new Gson();

        Type listType = new TypeToken<List<Holidays>>() {}.getType();

        List<Holidays> list = gson.fromJson(jsonData.loadFileFromClasspath("src/main/resources/db_holidaysNational1.json"), listType);

        System.out.println(gson.toJson(list));
        return list;

    }
    //3.
    public String loadFileFromClasspath(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

}

