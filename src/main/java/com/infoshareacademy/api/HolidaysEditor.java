package com.infoshareacademy.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HolidaysEditor {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private List<Holidays> holidayEdition = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private boolean isInputInvalid;
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

        createList = sortByDate(createList);

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

        String enteredYear;
        String enteredMonth;
        String enteredDay;
        String enteredDate;

        do{
            isInputInvalid = false;

            STDOUT.info("Enter the holiday's year\n");
            enteredYear = giveYear();
            STDOUT.info("\n");

            STDOUT.info("Enter the holiday's month\n");
            enteredMonth = giveMonth();
            STDOUT.info("\n");

            STDOUT.info("Enter the holiday's day\n");
            enteredDay = giveDay();
            STDOUT.info("\n");

            try{
                enteredDate = enteredDay + "" + enteredMonth + "" + enteredYear;

                SimpleDateFormat dateVerifier = new SimpleDateFormat("ddMMyyyy");
                Date javaDate = dateVerifier.parse(enteredDate);

            }
            catch (Exception e){
                STDOUT.error("Incorrect date! Enter date again.");
                isInputInvalid = true;
            }

        }
        while (isInputInvalid);

        enteredHolidayDateTime = new HolidayDateTime(Integer.parseInt(enteredYear), Integer.parseInt(enteredMonth), Integer.parseInt(enteredDay));

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

    private String giveYear() {
        isInputInvalid = false;
        Integer requestedYear = 0;

        do {
            try {
                STDOUT.info("The year has to be series of four numbers:\n");
                requestedYear = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e);
                isInputInvalid = true;
            }

            if (requestedYear < 1899) isInputInvalid = true;
        }
        while (isInputInvalid);

        return Integer.toString(requestedYear);
    }

    private String giveMonth() {
        Integer requestedMonth = 0;
        String requestedMonthString = "";

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

        requestedMonthString = Integer.toString(requestedMonth);

        if(requestedMonthString.length() == 1){ requestedMonthString = "0" + requestedMonthString; }

        return requestedMonthString;
    }

    private String giveDay() {
        isInputInvalid = false;
        Integer requestedDay = 0;
        String requestedDayString;

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

        requestedDayString = Integer.toString(requestedDay);

        if(requestedDayString.length() == 1){ requestedDayString = "0" + requestedDayString; }

        return requestedDayString;
    }

    private List<Holidays>sortByDate(List<Holidays>listToSort){

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

}
