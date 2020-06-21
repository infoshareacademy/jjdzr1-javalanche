package com.infoshareacademy.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static List<Holidays> listBuilder(HolidaysJsonData holidaysJsonData) {

        List<Holidays> allHolidayList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            allHolidayList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
        }
        return allHolidayList;
    }

    public static List<String> getImportantInfo(HolidaysJsonData holidaysJsonData) {

        List<String> importantInfoList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            importantInfoList.add("\n" + holidaysJsonData.getServerResponse().getHolidays().get(i).getName() + " - " + holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getIso()
                    + "\n" + holidaysJsonData.getServerResponse().getHolidays().get(i).getDescription() + "\n");
        }
        STDOUT.info(importantInfoList + "\n");
        return importantInfoList;
    }

    public static List<String> getHolidayDateList(HolidaysJsonData holidaysJsonData) {

        List<String> holidayDateList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            holidayDateList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().toString());
        }
        return holidayDateList;
    }

    public static List<String> getHolidayIsoDateList(HolidaysJsonData holidaysJsonData) {

        List<String> holidayIsoDateList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            holidayIsoDateList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getIso());
        }
        return holidayIsoDateList;
    }

    public static List<String> getHolidayDescriptionList(HolidaysJsonData holidaysJsonData) {

        List<String> holidayDescriptionList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            holidayDescriptionList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getDescription());
        }
        return holidayDescriptionList;
    }

    public static List<String> getHolidayDateTimeList(HolidaysJsonData holidaysJsonData) {

        List<String> holidayDateTimeList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            holidayDateTimeList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getHolidayDateTime().toString());
        }
        return holidayDateTimeList;
    }

    public static List<String> getHolidayNamesList(HolidaysJsonData holidaysJsonData) {

        List<String> holidayNamesList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            holidayNamesList.add(holidaysJsonData.getServerResponse().getHolidays().get(i).getName());
        }
        return holidayNamesList;
    }

}
