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
        index = 1;
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
        MainMenu.STDOUT.info("1. Print chosen holiday details.\n");
        MainMenu.STDOUT.info("2. Back to view menu.\n");
        MainMenu.STDOUT.info("3. Back to main menu.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
            MainMenu.STDOUT.info("================================================================================ \n");
            MainMenu.STDOUT.info("Main menu -> View calendar -> View holidays in this month -> View chosen holiday \n");
            MainMenu.STDOUT.info("================================================================================ \n");
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

    public static void printOneElement(HolidaysJsonData holidaysJsonData) {

        MainMenu.STDOUT.info("Please choose holiday number.\n");

        try {
            Scanner scanner = new Scanner(System.in);
            Integer option = scanner.nextInt();
            option--;
            MainMenu.STDOUT.info("================================================================================ \n");
            MainMenu.STDOUT.info("Main menu -> View calendar -> View holidays in this month -> View chosen holiday \n");
            MainMenu.STDOUT.info("================================================================================ \n");
            STDOUT.info(listBuilder(holidaysJsonData).get(option).toString());

        } catch (Exception e) {
            printOneElement(holidaysJsonData);
        }
    }

    public static List<String> getImportantInfo2ndVersion(List<Holidays> oneElementViewList) {
        index = 1;
        MainMenu.STDOUT.info("================================================ \n");
        MainMenu.STDOUT.info("Main menu -> View calendar -> View all holidays \n");
        MainMenu.STDOUT.info("================================================ \n");
        List<String> importantInfoList = new ArrayList<>();

        for (Holidays holidays : oneElementViewList) {
            importantInfoList.add(" \n" + index + ". " + holidays.getName() + " - " +
                    holidays.getHolidayDate().getIso()
                    + "\n" + holidays.getDescription() + "\n ");
        }
        String r = importantInfoList.toString().replace("[", "").replace("]", "").
                replace(" , ", "");

        STDOUT.info(r + "\n");
        return importantInfoList;
    }

}





