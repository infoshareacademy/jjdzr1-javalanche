package com.infoshareacademy.api;

import com.infoshareacademy.menu.MenuSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class HolidaysEditor {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private List<Holidays> holidayEdition = HolidaysJsonData.readDataFromJsonFile().getServerResponse().getHolidays();
    private Scanner scanner = new Scanner(System.in);

    private boolean isInputInvalid;


    public void setHolidayEdition() {
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();

        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            holidayEdition.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
        }
    }

    public List<Holidays> editHolidaysList(List<Holidays> listToEdit) {

        //setHolidayEdition();

        boolean isSearchValid;


        List<Integer> queriesIndexes = findIndexes(listToEdit);

        if (queriesIndexes.size() == 1) {

            Integer usersInput = 0;

            do {

                isInputInvalid = false;

                try {
                    STDOUT.info("Enter if you would like to:\n" +
                            "1: Create new holiday.\n" +
                            "2: Edit this holiday. \n" +
                            "3: Delete this holiday. \n");
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
                    holidayEdition = createElement();
                    break;
                case 2:
                    holidayEdition = updateElement(queriesIndexes.get(0));
                    break;
                case 3:
                    holidayEdition = deleteElement(queriesIndexes.get(0));
                    break;
            }
        }
        else if (queriesIndexes.size() > 1){
            STDOUT.info("Limit your search to one holiday query.\n\n");
            MenuSearch.menuSearch();
        }
        else {
            MenuSearch.menuSearch();
        }

        for (Holidays holidays : holidayEdition){
            System.out.println(holidays.toString());
        }

        return holidayEdition;

    }

    public List<Holidays> createElement() {
        STDOUT.info("\n\nCreating a holiday query. \n ******************** \n\n");

        Holidays createHoliday = new Holidays(name(), description(), country(), holidayDate(), type(), locations(), states());
        holidayEdition.add(createHoliday);

        holidayEdition = sortByDate(holidayEdition);

        return holidayEdition;
    }

    public List<Holidays> readElement(Integer holidayIndex) {
        STDOUT.info("\n\nRead a holiday query. \n************************ \n\n");

        STDOUT.info(holidayEdition.get(holidayIndex).toString());

        return holidayEdition;
    }

    public List<Holidays> updateElement(Integer holidayIndex) {
        STDOUT.info("\n\nUpdate a holiday query. \n************************ \n\n");

        Holidays updateHoliday = holidayEdition.get(holidayIndex);

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

                holidayEdition.get(holidayIndex).setName(updatedHolidaysName);
                break;
            case 2:
                String updatedHolidaysDescription = description();

                holidayEdition.get(holidayIndex).setDescription(updatedHolidaysDescription);
                break;
            case 3:
                HolidayDate updatedHolidaysDate = holidayDate();

                holidayEdition.get(holidayIndex).setHolidayDate(updatedHolidaysDate);
                break;
        }

        holidayEdition = sortByDate(holidayEdition);

        return holidayEdition;
    }

    public List<Holidays> deleteElement(Integer holidayIndex) {
        STDOUT.info("\n\nDelete a holiday query. \n************************ \n\n");

        List<Holidays> deleteElement = new ArrayList<>(holidayEdition);

        String decision;

        STDOUT.info(holidayEdition.get(holidayIndex).toString() + "Are you sure you want to delete this query?\n");

        do {
            STDOUT.info("\nEnter your decision Y/N\n");
            scanner = new Scanner(System.in);
            decision = scanner.nextLine();
        }
        while (!decision.toLowerCase().equals("y") && !decision.toLowerCase().equals("n"));

        if (decision.toLowerCase().equals("y")) {

            int intIndexForList = holidayIndex;
            holidayEdition.remove(intIndexForList);

        }

        return holidayEdition;

    }

    /*private static Integer findHoliday() {

        Holidays foundHoliday = null;
        String searchedHoliday;
        Integer foundHolidaysCounter;
        foundHolidayIndex = 0;

        printElement();

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
    }*/

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

        do {
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

            try {
                enteredDate = enteredDay + "" + enteredMonth + "" + enteredYear;

                DateFormat df = new SimpleDateFormat("ddMMyyy");
                df.setLenient(false);
                df.parse(enteredDate);
            } catch (Exception e) {
                STDOUT.error("Error: " + e + "\n");
                STDOUT.error("Incorrect date! Enter date again.\n");
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

        if (requestedMonthString.length() == 1) {
            requestedMonthString = "0" + requestedMonthString;
        }

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

        if (requestedDayString.length() == 1) {
            requestedDayString = "0" + requestedDayString;
        }

        return requestedDayString;
    }

    private List<Holidays> sortByDate(List<Holidays> listToSort) {

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

    private List<Integer> findIndexes(List<Holidays> listToFindMatch) {
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();

        List<Integer> queriesIndexes = new ArrayList<>();

        Integer index = 0;

        for (Holidays holiday : holidaysJsonData.getServerResponse().getHolidays()) {

            for (Holidays holidayToEdit : listToFindMatch) {

                if (holiday.getName().toLowerCase().contains(holidayToEdit.getName().toLowerCase())) {

                    queriesIndexes.add(index);
                }

            }

            index++;

        }

        return queriesIndexes;

    }

}
