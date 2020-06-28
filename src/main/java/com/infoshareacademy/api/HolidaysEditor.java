package com.infoshareacademy.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HolidaysEditor {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private List<Holidays> holidayEdition = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private boolean isInputInvalid;
    private Integer requestedYear;
    private Integer requestedMonth;
    private Integer requestedDay;
    private Integer foundHolidayIndex;

    public HolidaysEditor(HolidaysJsonData holidaysJsonData) {
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            this.holidayEdition.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
        }

    }

    public void createElement() {
        STDOUT.info("Creating a holiday query. \n ******************** \n\n");

        List<Holidays> createList = new ArrayList<>(holidayEdition);

        Holidays createHoliday = new Holidays(name(), description(), country(), holidayDate(), type(), locations(), states());
        createList.add(createHoliday);

        for (Holidays holiday : createList) {
            System.out.println(holiday.toString());
        }
    }

    public void readElement() {
        STDOUT.info("Read a holiday query. \n************************ \n\n");

        STDOUT.info(holidayEdition.get(findHoliday()).toString());
    }

    public void updateElement() {
        STDOUT.info("Update a holiday query. \n************************ \n\n");

        List<Holidays> updateList = new ArrayList<>(holidayEdition);

        foundHolidayIndex = findHoliday();

        Holidays updateHoliday = updateList.get(foundHolidayIndex);

        System.out.println(updateHoliday.toString());

        Integer usersInput = 0;
        do {

            isInputInvalid = false;

            try {
                STDOUT.info("Enter which element of the holiday's query would you like to change:\n" +
                        "1: Holiday's name.\n" +
                        "2: Holiday's description\n" +
                        "3: Holiday's date\n");
                scanner = new Scanner(System.in);

                usersInput = scanner.nextInt();


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
                String updatedHolidaysName = name();

                updateList.get(foundHolidayIndex).setName(updatedHolidaysName);
                //updateHoliday.setName(updatedHolidaysName);
                break;
            case 2:
                String updatedHolidaysDescription = description();
                updateHoliday.setDescription(updatedHolidaysDescription);
                break;
            case 3:
                HolidayDate updatedHolidaysDate = holidayDate();
                updateHoliday.setHolidayDate(updatedHolidaysDate);
                break;
        }

        System.out.println(updateList.get(foundHolidayIndex).toString());

    }

    public void deleteElement() {
        STDOUT.info("Delete a holiday query. \n************************ \n\n");

        List<Holidays> deleteTest = new ArrayList<>(holidayEdition);

        int foundHolidayIndex = findHoliday();

        System.out.println("foundHolidayIndex:" + foundHolidayIndex + "\n\n");

        //Why doesn't it work on Integer?
        deleteTest.remove(foundHolidayIndex);

        int i = 0;
        for (Holidays holiday : deleteTest) {
            System.out.println(i);
            System.out.println(holiday.toString());
            i++;
        }
    }

    private Integer findHoliday() {

        Holidays foundHoliday = null;
        String searchedHoliday;
        Integer foundHolidaysCounter;
        foundHolidayIndex = 0;

        do {
            isInputInvalid = false;
            foundHolidaysCounter = 0;
            STDOUT.info("Enter sequence of at least three letters.\n");
            searchedHoliday = scanner.nextLine();

            if (searchedHoliday.length() < 3) {
                STDOUT.error("Input has to got at least 3 letters\n");
                isInputInvalid = true;
            } else {

                for (Holidays holiday : holidayEdition) {

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

        return foundHolidayIndex;
    }

    private String name() {
        STDOUT.info("Enter holiday's name\n");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        STDOUT.info("\n");
        return name;
    }

    private String description() {
        STDOUT.info("Enter holiday's description\n");
        scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        STDOUT.info("\n");
        return description;
    }

    private Country country() {
        Country enteredCountry = new Country("pl", "Poland");
        return enteredCountry;
    }

    private HolidayDate holidayDate() {
        HolidayDate enteredHolidayDate;
        HolidayDateTime enteredHolidayDateTime;

        STDOUT.info("Enter the holiday's year\n");
        Integer enteredYear = giveYear();
        STDOUT.info("\n");

        STDOUT.info("Enter the holiday's month\n");
        Integer enteredMonth = giveMonth();
        STDOUT.info("\n");

        STDOUT.info("Enter the holiday's day\n");
        Integer enteredDay = giveDay();
        STDOUT.info("\n");

        enteredHolidayDateTime = new HolidayDateTime(enteredYear, enteredMonth, enteredDay);

        String dateISOformat = enteredYear + "-" + enteredMonth + "-" + enteredDay;
        enteredHolidayDate = new HolidayDate(dateISOformat, enteredHolidayDateTime);

        return enteredHolidayDate;
    }

    private List<String> type() {
        List<String> enteredTypes = new ArrayList<>();
        enteredTypes.add("National holiday");
        return enteredTypes;
    }

    private String locations() {
        String locations = "All";
        return locations;
    }

    private String states() {
        String states = "All";
        return states;
    }

    private Integer giveYear() {
        isInputInvalid = false;
        requestedYear = 0;

        do {
            try {
                STDOUT.info("The year has to be series of four numbers:\n");
                requestedYear = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e);
                isInputInvalid = true;
            }
        }
        while (isInputInvalid);

        return requestedYear;
    }

    private Integer giveMonth() {
        int requestedMonth = 0;

        do {
            isInputInvalid = false;

            try {
                STDOUT.info("The month has to be a number between 1 and 12:\n");
                requestedMonth = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e);
                isInputInvalid = true;
            }

            if (requestedMonth < 1 || requestedMonth > 12) isInputInvalid = true;
        }
        while (isInputInvalid);

        return requestedMonth;
    }

    private Integer giveDay() {
        isInputInvalid = false;
        int requestedDay = 0;

        do {
            try {
                STDOUT.info("The day has to be a number between 1 and 31:\n");
                requestedDay = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e);
                isInputInvalid = true;
            }

            if (requestedDay < 1 || requestedDay > 31) isInputInvalid = true;
        }
        while (isInputInvalid);

        return requestedDay;
    }

}
