package com.infoshareacademy.edit;

import com.infoshareacademy.api.*;
import com.infoshareacademy.menu.MainMenu;
import com.infoshareacademy.menu.MenuEdit;
import com.infoshareacademy.menu.MenuSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class HolidaysEditor {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private static List<Holidays> holidayEdition = HolidaysJsonData.readDataFromJsonFile().getServerResponse().getHolidays();
    private static Scanner scanner = new Scanner(System.in);

    private static boolean isInputInvalid;

    public static List<Holidays> createElement() {

        Holidays createHoliday = new Holidays(name(), description(), country(), holidayDate(), type(), locations(), states());
        holidayEdition.add(createHoliday);

        STDOUT.info(createHoliday.toString() + "This holiday is created.\n\n");

        holidayEdition = sortByDate(holidayEdition);

        return holidayEdition;
    }

    // This method may be adapted in future.
/*    public static List<Holidays> readElement() {

        for (Holidays holiday : holidayEdition) {
            System.out.println(holiday.toString());
        }

        return holidayEdition;
    }*/

    public static List<Holidays> updateElement() {

        Integer holidayIndex = findHoliday();

        if (holidayIndex != null) {

            Holidays updateHoliday = holidayEdition.get(holidayIndex);

            STDOUT.info(updateHoliday.toString() + "This holiday is to be edited.\n\n");

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

            STDOUT.info(holidayEdition.get(holidayIndex).toString() + "The edited holiday\n\n");

            holidayEdition = sortByDate(holidayEdition);

        } else {
            STDOUT.info("You will return to holidays editor menu.\n\n");
        }

        return holidayEdition;
    }

    public static List<Holidays> deleteElement() {

        Integer holidayIndex = findHoliday();

        if (holidayIndex != null) {

            String decision;

            STDOUT.info(holidayEdition.get(holidayIndex).toString() + "Are you sure you want to delete this query?\n\n");

            do {
                STDOUT.info("Enter your decision Y/N\n");
                scanner = new Scanner(System.in);
                decision = scanner.nextLine();
                STDOUT.info("\n");
            }
            while (!decision.toLowerCase().equals("y") && !decision.toLowerCase().equals("n"));

            if (decision.toLowerCase().equals("y")) {

                int intIndexForList = holidayIndex;
                holidayEdition.remove(intIndexForList);

            }
        } else {
            STDOUT.info("You will return to holidays editor menu.\n\n");
        }

        return holidayEdition;

    }

    private static String name() {
        STDOUT.info("Enter holiday's name\n");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        STDOUT.info("\n");
        return name;
    }

    private static String description() {
        STDOUT.info("Enter holiday's description\n");
        scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        STDOUT.info("\n");
        return description;
    }

    private static Country country() {
        Country enteredCountry = new Country("pl", "Poland");
        return enteredCountry;
    }

    private static HolidayDate holidayDate() {

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

    private static List<String> type() {
        List<String> enteredTypes = new ArrayList<>();
        enteredTypes.add("National holiday");
        return enteredTypes;
    }

    private static String locations() {
        String locations = "All";
        return locations;
    }

    private static String states() {
        String states = "All";
        return states;
    }

    private static String giveYear() {
        isInputInvalid = false;
        Integer requestedYear = 0;

        do {
            isInputInvalid = false;
            try {
                STDOUT.info("The year has to be between 1899 and " + Calendar.getInstance().get(Calendar.YEAR) + ".\n");
                scanner = new Scanner(System.in);
                requestedYear = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found: " + e + "\n");
                isInputInvalid = true;
            }

            if (requestedYear < 1899 || requestedYear > Calendar.getInstance().get(Calendar.YEAR)) {
                isInputInvalid = true;
            }
        }
        while (isInputInvalid);

        return Integer.toString(requestedYear);
    }

    private static String giveMonth() {
        Integer requestedMonth = 0;
        String requestedMonthString = "";

        do {
            isInputInvalid = false;
            try {
                STDOUT.info("The month has to be a number between 1 and 12:\n");
                scanner = new Scanner(System.in);
                requestedMonth = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e + "\n");
                isInputInvalid = true;
            }

            if (requestedMonth < 1 || requestedMonth > 12) {
                isInputInvalid = true;
            }
        }
        while (isInputInvalid);

        requestedMonthString = Integer.toString(requestedMonth);

        if (requestedMonthString.length() == 1) {
            requestedMonthString = "0" + requestedMonthString;
        }

        return requestedMonthString;
    }

    private static String giveDay() {
        isInputInvalid = false;
        Integer requestedDay = 0;
        String requestedDayString;

        do {
            isInputInvalid = false;
            try {
                STDOUT.info("The day has to be a number between 1 and 31:\n");
                scanner = new Scanner(System.in);
                requestedDay = scanner.nextInt();
            } catch (Exception e) {
                STDOUT.info("Error found:" + e + "\n");
                isInputInvalid = true;
            }

            if (requestedDay < 1 || requestedDay > 31) {
                isInputInvalid = true;
            }
        }
        while (isInputInvalid);

        requestedDayString = Integer.toString(requestedDay);

        if (requestedDayString.length() == 1) {
            requestedDayString = "0" + requestedDayString;
        }

        return requestedDayString;
    }

    private static List<Holidays> sortByDate(List<Holidays> listToSort) {

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

    private static Integer findHoliday() {

        Holidays foundHoliday = null;
        String searchedHoliday;
        Integer foundHolidaysCounter;
        Integer foundHolidayIndex = 0;

        do {
            isInputInvalid = false;
            foundHolidaysCounter = 0;
            foundHolidayIndex = 0;
            STDOUT.info("Enter sequence of at least three letters.\n");

            scanner = new Scanner(System.in);
            searchedHoliday = scanner.nextLine();
            STDOUT.info("\n");

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
                    foundHolidayIndex = null;
                    isInputInvalid = true;
                    break;
                }

                if (foundHolidaysCounter > 1) {
                    STDOUT.error("More the one result found, narrow your search.\n");
                    foundHolidayIndex = null;
                    isInputInvalid = true;
                    break;
                }

                if (foundHolidayIndex >= holidayEdition.size()) {
                    foundHolidayIndex = null;
                }
            }


        }
        while (isInputInvalid);


        return foundHolidayIndex;
    }

    //May be used in future when this class will be edited.
    private static void printList() {

        for (Holidays holiday : holidayEdition) {
            STDOUT.info(holiday.toString());
        }
    }

    public static List<Holidays> getHolidayEdition() {
        return holidayEdition;
    }
}
