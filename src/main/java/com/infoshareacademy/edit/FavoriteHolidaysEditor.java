package com.infoshareacademy.edit;

import com.infoshareacademy.api.Holidays;
import com.infoshareacademy.api.HolidaysJsonData;
import com.infoshareacademy.menu.MainMenu;
import com.infoshareacademy.menu.MenuEdit;

import java.util.*;

import static com.infoshareacademy.App.STDOUT;

public class FavoriteHolidaysEditor {

    private static List<Holidays> allHolidaysList = HolidaysJsonData.readDataFromJsonFile().getServerResponse().getHolidays();
    private static List<Holidays> favoriteHolidaysList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static boolean isInputInvalid;
    static boolean isDuplicate;

    public static List<Holidays> addFavoriteHolidays() {
        refreshFavoriteHolidays();

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
                STDOUT.info("Holiday not added.\n\n");
            } else if (isDuplicate(favoriteHolidayToAdd)) {
                STDOUT.info("The chosen holiday is already in the favorites. Holiday will not be added to the list.\n\n");
            } else {
                STDOUT.info("Holiday added.\n\n");
                favoriteHolidaysList.add(favoriteHolidayToAdd);
            }

            STDOUT.info("You will return to favorite holidays editor menu.\n\n");

        }

        return favoriteHolidaysList;
    }

    public static List<Holidays> removeFavoriteHolidays() {
        refreshFavoriteHolidays();

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
                STDOUT.info("This holidays has been removed from your favorites.\n\n");
                favoriteHolidaysList.remove(favoriteHolidayToRemove);
            }

        }

        STDOUT.info("You will return to favorite holidays editor menu.\n\n");

        return favoriteHolidaysList;
    }

    public static void printFavoriteHolidays() {
        refreshFavoriteHolidays();

        favoriteHolidaysList = sortFavoriteHolidays(favoriteHolidaysList);

        if (favoriteHolidaysList.size() == 0) {
            STDOUT.info("You have no favorite holidays\n\n");
        } else {
            STDOUT.info("You have " + favoriteHolidaysList.size() + " favorite holiday(s).\n\n");
        }

        for (Holidays holiday : favoriteHolidaysList) {
            STDOUT.info(holiday.toString());
        }

        STDOUT.info("You will return to favorite holidays editor menu.\n\n");
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

    private static boolean isDuplicate(Holidays checkForDuplicates) {

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

    private static List<Holidays> refreshFavoriteHolidays() {
        List<Integer> indexesToRemove = new ArrayList<>();

        List<Holidays> refreshedHolidaysList = new ArrayList<>();

        for (Holidays favoriteHoliday : favoriteHolidaysList) {

            for (Holidays holiday : HolidaysEditor.getHolidayEdition()) {


                if ((holiday.getHolidayDate().getIso().equals(favoriteHoliday.getHolidayDate().getIso()))) {

                    if (!(holiday.getName().equals(favoriteHoliday.getName()))) {
                        favoriteHoliday.setName(holiday.getName());
                    }

                    if (!(holiday.getDescription().equals(favoriteHoliday.getDescription()))) {
                        favoriteHoliday.setDescription(holiday.getDescription());
                    }

                    refreshedHolidaysList.add(favoriteHoliday);

                    break;
                }

            }

            favoriteHolidaysList = new ArrayList<>(refreshedHolidaysList);

        }

        return favoriteHolidaysList;
    }

}
