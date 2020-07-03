package com.infoshareacademy.api;

import java.util.*;

import static com.infoshareacademy.App.STDOUT;

public class FavoriteHolidaysEditor {

    private static List<Holidays> allHolidaysList = HolidaysJsonData.readDataFromJsonFile().getServerResponse().getHolidays();
    private static List<Holidays> favoriteHolidaysList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static boolean isInputInvalid;
    static boolean isDuplicate;

    public static void editFavoriteHolidays() {

        Integer usersInput = 0;

        do {

            isInputInvalid = false;

            try {
                STDOUT.info("Enter if you would like to:\n" +
                        "1: Print favorite holidays.\n" +
                        "2: Add a favorite holiday. \n" +
                        "3: Remove a holiday. \n");

                scanner = new Scanner(System.in);
                usersInput = scanner.nextInt();
                STDOUT.info("\n");

                if (usersInput < 1 || usersInput > 3) {
                    STDOUT.error("Input not within required range.\n\n");
                    isInputInvalid = true;
                }
            } catch (Exception e) {
                STDOUT.error("Error found: " + e + "\n" + "Enter a number between 1 and 3:\n");
                isInputInvalid = true;
            }

        }
        while (isInputInvalid);

        switch (usersInput) {
            case 1:
                printFavoriteHolidays();
                break;
            case 2:
                addFavoriteHolidays();
                break;
            case 3:
                removeFavoriteHolidays();
                break;
        }
    }

    public static List<Holidays> addFavoriteHolidays() {
        refreshFavoriteHolidays();

        STDOUT.info("Add a favorite holiday. \n************************ \n\n");

        Holidays favoriteHolidayToAdd = findHoliday();

        String usersDecision;

        if (favoriteHolidayToAdd != null) {
            STDOUT.info("\nDo you want to add this holiday to favorites?\n\n" + favoriteHolidayToAdd.toString());

            do {
                STDOUT.info("Enter your decision Y/N\n");
                scanner = new Scanner(System.in);
                usersDecision = scanner.nextLine();
                STDOUT.info("\n");
            }
            while (!usersDecision.toLowerCase().equals("y") && !usersDecision.toLowerCase().equals("n"));


            if (usersDecision.toLowerCase().equals("n")) {
                STDOUT.info("Holiday not added\n\n");
            } else if (noDuplicates(favoriteHolidayToAdd)) {
                STDOUT.info("Holiday already in favorites. Holiday not added\n\n");
            } else {
                STDOUT.info("Holiday added\n\n");
                favoriteHolidaysList.add(favoriteHolidayToAdd);
            }

        }

        return favoriteHolidaysList;
    }

    public static List<Holidays> removeFavoriteHolidays() {
        refreshFavoriteHolidays();

        STDOUT.info("Remove a favorite holiday. \n************************ \n\n");

        Holidays favoriteHolidayToRemove = findFavoriteHoliday();

        if (favoriteHolidayToRemove != null) {
            String usersDecision;

            STDOUT.info("\nDo you want to remove this holiday from favorites?\n\n" + favoriteHolidayToRemove.toString());

            do {
                STDOUT.info("Enter your decision Y/N\n");
                scanner = new Scanner(System.in);
                usersDecision = scanner.nextLine();
                STDOUT.info("\n");
            }
            while (!usersDecision.toLowerCase().equals("y") && !usersDecision.toLowerCase().equals("n"));

            if (usersDecision.toLowerCase().equals("y")) {
                favoriteHolidaysList.remove(favoriteHolidayToRemove);
            }

        }

        return favoriteHolidaysList;
    }

    public static void printFavoriteHolidays() {
        refreshFavoriteHolidays();

        favoriteHolidaysList = sortFavoriteHolidays(favoriteHolidaysList);

        if(favoriteHolidaysList.size() == 0){
            STDOUT.info("You have no favorite holidays\n\n");
        }
        else {
            STDOUT.info("You have " + favoriteHolidaysList.size() + " favorite holiday(s).\n\n" );
        }

        for (Holidays holiday : favoriteHolidaysList) {
            STDOUT.info(holiday.toString());
        }
    }

    private static Holidays findHoliday() {

        Holidays foundHoliday = null;
        String searchedHoliday;
        Integer foundHolidaysCounter;
        Integer foundHolidayIndex = 0;


        isInputInvalid = false;
        foundHolidaysCounter = 0;
        STDOUT.info("Enter sequence of at least three letters.\n");
        scanner = new Scanner(System.in);
        searchedHoliday = scanner.nextLine();

        if (searchedHoliday.length() < 3) {
            STDOUT.error("Input has to got at least 3 letters\n");
            isInputInvalid = true;
        } else {

            for (Holidays holiday : allHolidaysList) {

                if (holiday.getName().toLowerCase().contains(searchedHoliday.toLowerCase())) {
                    foundHolidaysCounter++;

                    foundHoliday = holiday;
                }

                if (foundHolidaysCounter == 0) {
                    foundHolidayIndex++;
                }
            }

            if (foundHolidaysCounter == 0) {
                STDOUT.error("No results found.\n\n");
                isInputInvalid = true;
            } else if (foundHolidaysCounter != 1) {
                STDOUT.error("More the one result found, narrow your search.\n\n");
                isInputInvalid = true;
            }
        }

        return foundHoliday;
    }

    private static Holidays findFavoriteHoliday() {

        Holidays foundHoliday = null;
        String searchedHoliday;
        Integer foundHolidaysCounter;
        Integer foundHolidayIndex = 0;

        isInputInvalid = false;
        foundHolidaysCounter = 0;
        STDOUT.info("Enter sequence of at least three letters.\n");
        scanner = new Scanner(System.in);
        searchedHoliday = scanner.nextLine();

        if (searchedHoliday.length() < 3) {
            STDOUT.error("Input has to got at least 3 letters\n");
            isInputInvalid = true;
        } else {

            for (Holidays holiday : favoriteHolidaysList) {

                if (holiday.getName().toLowerCase().contains(searchedHoliday.toLowerCase())) {
                    foundHolidaysCounter++;

                    foundHoliday = holiday;
                }

                if (foundHolidaysCounter == 0) {
                    foundHolidayIndex++;
                }
            }

            if (foundHolidaysCounter == 0) {
                STDOUT.error("No results found.\n\n");
                isInputInvalid = true;
            } else if (foundHolidaysCounter != 1) {
                STDOUT.error("More the one result found, narrow your search.\n\n");
                isInputInvalid = true;
            }
        }

        return foundHoliday;
    }

    private static boolean noDuplicates(Holidays checkForDuplicates) {

        isDuplicate = false;

        for (Holidays holiday : favoriteHolidaysList) {
            if (holiday.getHolidayDate().getIso().equals(checkForDuplicates.getHolidayDate().getIso())) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }

    private static List<Holidays> sortFavoriteHolidays(List<Holidays> listToSort) {

        Collections.sort(listToSort, new Comparator<Holidays>() {

            @Override
            public int compare(Holidays holidays1, Holidays holidays2) {

                String holiday1date = holidays1.getHolidayDate().getIso().replaceAll("-", "");

                String holiday2date = holidays2.getHolidayDate().getIso().replaceAll("-", "");

                return Integer.parseInt(holiday1date) - Integer.parseInt(holiday2date);
            }

        });

        return listToSort;

    }

    private static void refreshFavoriteHolidays() {
        boolean doHolidayMatch;

        for(Holidays favoriteHoliday : favoriteHolidaysList){

            doHolidayMatch = false;

            for(Holidays holiday : allHolidaysList){

                if((holiday.getHolidayDate().getIso().equals(favoriteHoliday.getHolidayDate().getIso()))){

                    if(!(holiday.getName().equals(favoriteHoliday.getName()))){
                        favoriteHoliday.setName(holiday.getName());
                    }

                    if(!(holiday.getDescription().equals(favoriteHoliday.getDescription()))){
                        favoriteHoliday.setDescription(holiday.getDescription());
                    }

                    doHolidayMatch = true;
                }

            }

            if (!doHolidayMatch){
                favoriteHolidaysList.remove(favoriteHoliday);
            }

        }
    }

}
