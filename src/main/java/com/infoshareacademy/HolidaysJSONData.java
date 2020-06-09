package com.infoshareacademy;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class HolidaysJSONData {
    @SerializedName("meta")
    @Expose
    private ServerInfo serverInfo;
    @SerializedName("response")
    @Expose
    private ServerResponse serverResponse;

    public HolidaysJSONData() {
    }

    public HolidaysJSONData(ServerInfo serverInfo, ServerResponse serverResponse) {
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

    public static HolidaysJSONData readDataFromJsonFile() {
        Gson gson = new Gson();
        HolidaysJSONData holidaysJSONData = new HolidaysJSONData();
        try (Reader reader1 = new FileReader("src/main/resources/db_holidaysNational.json")) {
            holidaysJSONData = gson.fromJson(reader1, HolidaysJSONData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return holidaysJSONData;
    }

}
