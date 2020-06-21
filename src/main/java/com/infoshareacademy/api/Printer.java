package com.infoshareacademy.api;

import java.util.ArrayList;
import java.util.List;

public class Printer {

    public static List<Holidays> listBuilder(HolidaysJsonData holidaysJsonData) {

        List<Holidays> allHolidayList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            allHolidayList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
        }
        // Check for printing whole List
        //System.out.println(allHolidayList);
        return allHolidayList;
    }

    public static List<String> getImportantInfo (HolidaysJsonData holidaysJsonData) {

        List<String> importantInfoList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            importantInfoList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getName() + " - " +holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getIso());
            //importantInfoList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getIso());
            //importantInfoList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getType().toString());

        }
        // Check for printing importantInfo list
        //System.out.println(importantInfoList);
        return importantInfoList;
    }



}
