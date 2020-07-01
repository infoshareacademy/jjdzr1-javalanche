package com.infoshareacademy.api;

import com.infoshareacademy.search.SearchingInApi;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.infoshareacademy.App.STDOUT;

public class FavoriteHolidaysEditor {

    private List<Holidays> allHolidaysList = HolidaysJsonData.readDataFromJsonFile().getServerResponse().getHolidays();
    private List<Holidays> favoriteHolidaysList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    boolean isInputInvalid;
    boolean isDuplicate;

    public void editFavoriteHolidays() {

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

    public void addFavoriteHolidays() {
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
    }

    public void removeFavoriteHolidays() {
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
    }

    public void printFavoriteHolidays() {

        favoriteHolidaysList = sortFavoriteHolidays(favoriteHolidaysList);

        if(favoriteHolidaysList.size() == 0){
            STDOUT.info("You have no favorite holidays\n\n");
        }

        for (Holidays holiday : favoriteHolidaysList) {
            STDOUT.info(holiday.toString());
        }
    }

    private Holidays findHoliday() {

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

    private Holidays findFavoriteHoliday() {

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

    private boolean noDuplicates(Holidays checkForDuplicates) {

        isDuplicate = false;

        for (Holidays holiday : favoriteHolidaysList) {
            if (holiday.getName().equals(checkForDuplicates.getName())) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }

    private List<Holidays> sortFavoriteHolidays(List<Holidays> listToSort) {

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

    private void refreshFavoriteHolidays() {
    }

}
