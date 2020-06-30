package com.infoshareacademy.api;

import com.infoshareacademy.menu.MainMenu;
import com.infoshareacademy.menu.MenuViewHolidays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Printer {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static int index = 1;

    public static List<Holidays> listBuilder(HolidaysJsonData holidaysJsonData) {

        List<Holidays> allHolidayList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            allHolidayList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
        }
        return allHolidayList;
    }

    public static List<String> getImportantInfo(HolidaysJsonData holidaysJsonData) {
        MainMenu.STDOUT.info("================================================ \n");
        MainMenu.STDOUT.info("Main menu -> View calendar -> View all holidays \n");
        MainMenu.STDOUT.info("================================================ \n");

        List<String> importantInfoList = new ArrayList<>();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            importantInfoList.add(" \n" + index + ". " + holidaysJsonData.getServerResponse().getHolidays().get(i).getName() + " - " + holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getIso()
                    + "\n" + holidaysJsonData.getServerResponse().getHolidays().get(i).getDescription() + "\n ");
            index++;
        }

        String r = importantInfoList.toString().replace("[", "").replace("]", "").
                replace(" , ", "");

        STDOUT.info(r + "\n");
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

    public static List<Holidays> getHolidaysInSpecifyMonth(HolidaysJsonData holidaysJsonData, Integer integer) {

        List<Holidays> holidaysOnThisMonthList = new ArrayList<>();
        for (Holidays holiday : holidaysJsonData.getServerResponse().getHolidays()) {
            if (holiday.getHolidayDate().getHolidayDateTime().getMonth().equals(integer)) {
                holidaysOnThisMonthList.add(holiday);
            }
        }
        return holidaysOnThisMonthList;
    }

    public static void printOneElementOption(HolidaysJsonData holidaysJsonData) {
        MainMenu.STDOUT.info("Print chosen holiday details press 1.\n");
        MainMenu.STDOUT.info("Back to view menu press 2.\n");
        MainMenu.STDOUT.info("Back to main menu press 3.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
        printOneElement(holidaysJsonData);
        printOneElementOption(holidaysJsonData);

        } else if (option.charAt(0) == '2') {
            MenuViewHolidays.menuViewHolidays(holidaysJsonData);
        } else if (option.charAt(0) == '3') {
            MainMenu.mainMenu();
        } else {
            MenuViewHolidays.backToMenu(holidaysJsonData);
        }
    }
    //TODO catch exceptions
    public static void printOneElement(HolidaysJsonData holidaysJsonData) {
//        Map<Integer, Holidays> holidaysMap = new TreeMap<>();
//        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
//            holidaysMap.put(index, holidaysJsonData.getServerResponse().getHolidays().get(i));
//
//        }
        do {
            MainMenu.STDOUT.info("Please choose holiday number.\n");
            try {
                Scanner scanner = new Scanner(System.in);
                Integer option = scanner.nextInt();
                option--;
                STDOUT.info(listBuilder(holidaysJsonData).get(option).toString());
                break;
            }
            catch ( Exception e){
                printOneElement(holidaysJsonData);
            }

//            if (option < 1 || option > 13) {
//                printOneElement(holidaysJsonData);
//            } else if (option != Integer) {
//
//            } else {
//                STDOUT.info(listBuilder(holidaysJsonData).get(option).toString());
//                //STDOUT.info(holidaysMap.get(option).toString());
//            }

        }while (true);
    }
}




