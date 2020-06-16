package com.infoshareacademy;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ServerResponse {
    @SerializedName("holidays")
    @Expose
    private List<Holidays> holidays;

    public ServerResponse(List<Holidays> holidays) {
        this.holidays = holidays;
    }

    public void setHolidays(List<Holidays> holidays) {
        this.holidays = holidays;
    }

     public List<Holidays> getHolidays() {

         HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
         return holidays;
     }

    //1
    public static List<Holidays> getHolidays1(HolidaysJsonData holidaysJsonData) {

//        Function<HolidaysJsonData,Holidays> externalToHolidays = new Function<HolidaysJsonData, Holidays>() {
//            @Override
//            public Holidays apply(HolidaysJsonData holidaysJsonData) {
//                List<Holidays> list = new ArrayList<>();
//                list.add(holidays.get().getName())       //nie wiem co dać get
//            }
//        }
//        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
//        List<HolidaysJsonData> jsonList = new ArrayList<>();
//        jsonList.add(holidaysJsonData);
//
//        List<Holidays> allHolidayList = jsonList.stream().map(jsonList).collect(Collectors.<Holidays> toList());
//        for (Holidays holidays : holidays) {
//
//            allHolidayList.add(new Holidays(holidays.getName(), holidays.getDescription(), holidays.getCountry(),
//                    holidays.getHolidayDate(), holidays.getType(), holidays.getLocations(), holidays.getStates()));

        List<Holidays> allHolidayList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            allHolidayList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
            System.out.println(allHolidayList);
        }
//        for (List<Holidays> holidaysJsonData.getServerResponse().getHolidays() : holidays) {


//            allHolidayList.add(new Holidays(holidays.getName(), holidays.getDescription(), holidays.getCountry(),
//                    holidays.getHolidayDate(), holidays.getType(), holidays.getLocations(), holidays.getStates()));
//            allHolidayList.remove(holidays.getDescription());
//            allHolidayList.remove(holidays.getCountry());
//            allHolidayList.remove(holidays.getLocations());
//            allHolidayList.remove(holidays.getStates());
//        }
//        return allHolidayList;
return allHolidayList;
    }

}
