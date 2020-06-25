package com.infoshareacademy.search;

import com.infoshareacademy.App;
import com.infoshareacademy.api.Holidays;
import com.infoshareacademy.api.HolidaysJsonData;
import com.infoshareacademy.configurations.PropertiesReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchingInApi {


    public static void search() {
        Scanner scanner = new Scanner(System.in);

        App.STDOUT.info("Choose searching option: \n");
        App.STDOUT.info("1. Search by name: \n");
        App.STDOUT.info("2. Search by description: \n");
        App.STDOUT.info("3. Search by date: \n");
        App.STDOUT.info("4. Search by name and date: \n");

        String query = scanner.nextLine();
        switch (query.charAt(0)) {
            case '1': {
                searchByName();
                break;
            }
            case '2': {
                searchByDescr();
                break;
            }
            case '3': {
                searchByDate();
                break;
            }
            case '4': {
                searchByNameAndDate();
                break;
            }
            default: {
                search();
                break;
            }
        }
    }

    private static Integer numberOfFoundObjects;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Holidays> holidaysList = new ArrayList<>();

    public static void noObjectsFound() {
        App.STDOUT.info("\n\n" + "******* no objects found," +
                "search again using other keywords *******" + "\n\n");
    }

    public static void objectsFound() {
        App.STDOUT.info("\n\n" + "******* " + numberOfFoundObjects +
                " object(s) found listed below *******" + "\n\n");
        App.STDOUT.info(String.valueOf(holidaysList));
        App.STDOUT.info("\n\n" + "******* " + numberOfFoundObjects +
                " object(s) found listed above *******" + "\n\n");
    }

    //set holiday date to localDate format
    private static LocalDate getLocalDate(HolidaysJsonData holidaysJsonData, int i) {
        int takenYear = holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getHolidayDateTime().getYear();
        int takenMonth = holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getHolidayDateTime().getMonth();
        int takenDay = holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getHolidayDateTime().getDay();
        return LocalDate.of(takenYear, takenMonth, takenDay);
    }

    public static List<Holidays> searchByName() {
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        String queryName;
        do {
            App.STDOUT.info("Type the text you want to search by (min 3 digits): ");
            queryName = scanner.nextLine();
        } while (queryName.length() < 3);
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            if (holidaysJsonData.getServerResponse().getHolidays().get(i).getName().toLowerCase().contains(queryName.toLowerCase())) {
                holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
            }
        }
        numberOfFoundObjects = holidaysList.size();
        if (holidaysList.isEmpty()) {
            noObjectsFound();
        } else {
            objectsFound();
        }
        return holidaysList;
    }

    public static List<Holidays> searchByDescr() {
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        String queryDescr;
        do {
            App.STDOUT.info("Type the text you want to search by (min 3 digits): ");
            queryDescr = scanner.nextLine();
        }
        while (queryDescr.length() < 3);

        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            if (holidaysJsonData.getServerResponse().getHolidays().get(i).getDescription().toLowerCase().contains(queryDescr.toLowerCase())) {
                holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
            }
        }
        numberOfFoundObjects = holidaysList.size();
        if (holidaysList.isEmpty()) {
            noObjectsFound();
        } else {
            objectsFound();
        }
        return holidaysList;
    }

    public static List<Holidays> searchByDate() {
        //get date format from properties file
        PropertiesReader propertiesReader = new PropertiesReader();
        String dateFormat = propertiesReader.getDateFormat();

        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        String queryDate;
        do {
            App.STDOUT.info("Type part of the date in format " + dateFormat + " you want to search by (min 2 digits): ");
            queryDate = scanner.nextLine();
        }
        while (queryDate.length() < 2);

        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            //set holiday date to localDate format
            LocalDate takenData = getLocalDate(holidaysJsonData, i);

            //compare holiday date (takenData) to queryDate both in same format from properties file
            if (takenData.format(DateTimeFormatter.ofPattern(dateFormat)).contains(queryDate)) {
                holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
            }
        }
        numberOfFoundObjects = holidaysList.size();
        if (holidaysList.isEmpty()) {
            noObjectsFound();
        } else {
            objectsFound();
        }
        return holidaysList;
    }

    public static List<Holidays> searchByNameAndDate() {
        PropertiesReader propertiesReader = new PropertiesReader();
        String dateFormat = propertiesReader.getDateFormat();

        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();

        String queryName;
        String queryDate;
        do {
            App.STDOUT.info("Type the text you want to search by (min 3 digits): ");
            queryName = scanner.nextLine();

            App.STDOUT.info("Type part of the date in format " + dateFormat + " you want to search by (min 2 digits): ");
            queryDate = scanner.nextLine();
        }
        while (queryName.length() < 3 || queryDate.length() < 2);
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            LocalDate takenData = getLocalDate(holidaysJsonData, i);
            if (takenData.format(DateTimeFormatter.ofPattern(dateFormat)).contains(queryDate) && holidaysJsonData.getServerResponse().getHolidays().get(i).getName().toLowerCase().contains(queryName.toLowerCase())) {
                holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
            }
        }
        numberOfFoundObjects = holidaysList.size();
        if (holidaysList.isEmpty()) {
            noObjectsFound();
        } else {
            objectsFound();
        }
        return holidaysList;
    }
}

