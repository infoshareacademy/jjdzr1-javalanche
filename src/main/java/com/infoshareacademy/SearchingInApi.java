package com.infoshareacademy;

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
            default: {
                search();
                break;
            }
        }
    }

    public static List<Holidays> searchByName() {
        Scanner scanner = new Scanner(System.in);

        App.STDOUT.info("Type the text you want to search by (min 3 digits): ");

        String queryName = scanner.nextLine();
        List<Holidays> holidaysList = new ArrayList<>();
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        if (queryName.length() < 3) {
            searchByName();
        } else {
            for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
                if (holidaysJsonData.getServerResponse().getHolidays().get(i).getName().contains(queryName)) {
                    holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
                }
            }
        }
        App.STDOUT.info(String.valueOf(holidaysList));
        return holidaysList;
    }

    public static List<Holidays> searchByDescr() {
        Scanner scanner = new Scanner(System.in);

        App.STDOUT.info("Type the text you want to search by (min 3 digits): ");

        String queryDescr = scanner.nextLine();
        List<Holidays> holidaysList = new ArrayList<>();
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        if (queryDescr.length() < 3) {
            searchByDescr();
        } else {
            for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
                if (holidaysJsonData.getServerResponse().getHolidays().get(i).getDescription().contains(queryDescr)) {
                    holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
                }
            }
        }
        App.STDOUT.info(String.valueOf(holidaysList));
        return holidaysList;
    }

    public static List<Holidays> searchByDate() {
        Scanner scanner = new Scanner(System.in);

        App.STDOUT.info("Type part of the date in format YYYY-MM-DD you want to search by (min 3 digits): ");

        String queryDate = scanner.nextLine();
        List<Holidays> holidaysList = new ArrayList<>();
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        if (queryDate.length() < 3) {
            searchByDate();
        } else {
            for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
                if (holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getIso().contains(queryDate)) {
                    holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
                }
            }
        }
        App.STDOUT.info(String.valueOf(holidaysList));
        return holidaysList;
    }
}

