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
}
