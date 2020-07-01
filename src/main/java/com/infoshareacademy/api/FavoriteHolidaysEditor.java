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
    boolean isDecisionNegative;

    public void addFavoriteHolidays() {

        Holidays favoriteHolidayToAdd = findFavoriteHoliday();

        String usersDecision;

        STDOUT.info("Do you want to add this holiday to favorites?\n\n" + favoriteHolidayToAdd.toString());

        do {
            STDOUT.info("\nEnter your decision Y/N\n");
            scanner = new Scanner(System.in);
            usersDecision = scanner.nextLine();
            STDOUT.info("\n");
        }
        while (!usersDecision.toLowerCase().equals("y") && !usersDecision.toLowerCase().equals("n"));

        if (usersDecision.toLowerCase().equals("y")) {

            favoriteHolidaysList.add(favoriteHolidayToAdd);

        }

    }

    public void removeFavoriteHolidays() {
    }

    public void printFavoriteHolidays() {

        STDOUT.info("Test print");

        sortFavoriteHolidays();

        for (Holidays holiday : favoriteHolidaysList) {
            holiday.toString();
        }
    }

    private Holidays findFavoriteHoliday() {

        Holidays foundHoliday = null;
        String searchedHoliday;
        Integer foundHolidaysCounter;
        Integer foundHolidayIndex = 0;

        do {
            isInputInvalid = false;
            foundHolidaysCounter = 0;
            STDOUT.info("Enter sequence of at least three letters.\n");
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
                    STDOUT.error("No results found.\n");
                    isInputInvalid = true;
                } else if (foundHolidaysCounter != 1) {
                    STDOUT.error("More the one result found, narrow your search.\n");
                    isInputInvalid = true;
                }
            }

        }
        while (isInputInvalid);

        return foundHoliday;
    }


/*        boolean multipleObjectsReturned;
        List<Holidays> foundHolidays;

        do{
            multipleObjectsReturned = false;
            foundHolidays = SearchingInApi.searchByName();
            if (foundHolidays.size() != 1){
                multipleObjectsReturned = true;
            }
        }
        while (multipleObjectsReturned);

        Holidays foundHoliday = foundHolidays.get(0);

        return foundHoliday;
    }*/

    private void sortFavoriteHolidays() {

        Collections.sort(favoriteHolidaysList, new Comparator<Holidays>() {

            @Override
            public int compare(Holidays holidays1, Holidays holidays2) {

                String holiday1date = holidays1.getHolidayDate().getIso().replaceAll("-", "");

                String holiday2date = holidays2.getHolidayDate().getIso().replaceAll("-", "");

                return Integer.parseInt(holiday1date) - Integer.parseInt(holiday2date);
            }

        });

    }

    private void refreshFavoriteHolidays() {
    }

}
