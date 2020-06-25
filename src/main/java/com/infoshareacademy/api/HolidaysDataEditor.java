package com.infoshareacademy.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class HolidaysDataEditor {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");


    private HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
    private Scanner scanner = new Scanner(System.in);

    private boolean isInputInvalid;
    private int requestedYear;
    private int requestedMonth;
    private int requestedDay;

    public void createElement() {

    }

    public void readElement() {
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            if (holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getHolidayDateTime().getYear() == requestedYear &&
                    holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getHolidayDateTime().getMonth() == requestedMonth &&
                    holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getHolidayDateTime().getDay() == requestedDay) {
                STDOUT.info(holidaysJsonData.getServerResponse().getHolidays().get(i).toString());
                break;
            }

        }
    }

    public void updateElement() {

    }

    public void deleteElement() {

    }


    public int giveYear() {
        isInputInvalid = false;
        requestedYear = 0;

        do {
            try {
                STDOUT.info("The year has to be series of four numbers");
                requestedYear = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e);
                isInputInvalid = true;
            }
        }
        while (isInputInvalid);

        return requestedYear;
    }

    public int giveMonth() {
        isInputInvalid = false;
        int requestedMonth = 0;

        do {
            try {
                STDOUT.info("The year has to be series of four numbers");
                requestedMonth = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e);
                isInputInvalid = true;
            }
        }
        while (isInputInvalid);

        return requestedMonth;
    }

    public int giveDay() {
        isInputInvalid = false;
        int requestedDay = 0;

        do {
            try {
                STDOUT.info("The year has to be series of four numbers");
                requestedDay = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e);
                isInputInvalid = true;
            }
        }
        while (isInputInvalid);

        return requestedDay;
    }
}
