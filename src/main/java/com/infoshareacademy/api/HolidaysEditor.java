package com.infoshareacademy.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HolidaysEditor {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private List<Holidays> holidayEdition = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private List<Holidays> testList = new ArrayList<>(holidayEdition);

    private boolean isInputInvalid;
    private int requestedYear;
    private int requestedMonth;
    private int requestedDay;

    public HolidaysEditor(HolidaysJsonData holidaysJsonData) {
        for(int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++){
            this.holidayEdition.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
        }

    }

    public void createElement() {
        Holidays createHoliday = new Holidays(name(), description(), country(), holidayDate(), type(), locations(), states());
        testList.add(createHoliday);

        for(Holidays holiday : testList){
            System.out.println(holiday.toString());
        }
    }

    public void readElement() {
        STDOUT.info(findHoliday().toString());
    }

    public void updateElement() {

    }

    public void deleteElement() {

    }



    private Holidays findHoliday(){

        Holidays foundHoliday = null;
        String searchedHoliday;
        Integer foundHolidaysCounter;


        do{
            isInputInvalid = false;
            foundHolidaysCounter = 0;
            STDOUT.info("Enter sequence of at least three letters.\n");
            searchedHoliday = scanner.nextLine();

            if (searchedHoliday.length() < 3) {
                STDOUT.error("Input has to got at least 3 letters\n");
                isInputInvalid = true;
            }
            else {

                for(Holidays holiday : holidayEdition){

                    if(holiday.getName().toLowerCase().contains(searchedHoliday.toLowerCase())){
                        foundHolidaysCounter++;
                    }
                }

                if(foundHolidaysCounter == 0){
                    STDOUT.error("No results found.\n");
                    isInputInvalid = true;
                }
                else if (foundHolidaysCounter != 1) {
                    STDOUT.error("More the one result found, narrow your search.\n");
                    isInputInvalid = true;
                }
            }

        }
        while (isInputInvalid);

        for(Holidays holiday : holidayEdition){

            if(holiday.getName().toLowerCase().contains(searchedHoliday.toLowerCase())){
                foundHoliday = holiday;
            }

        }
        System.out.println("aaa" + foundHoliday.toString());
        return foundHoliday;
    }

    private String name(){
        STDOUT.info("Enter holiday's name\n");
        String name = scanner.nextLine();
        STDOUT.info("\n");
        return name;
    }

    private String description(){
        STDOUT.info("Enter holiday's description\n");
        String description = scanner.nextLine();
        STDOUT.info("\n");
        return description;
    }

    private Country country(){
        Country enteredCountry = new Country("pl", "Poland");
        return enteredCountry;
    }

    private HolidayDate holidayDate(){
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

    private List<String> type(){
        List<String>enteredTypes = new ArrayList<>();
        enteredTypes.add("National holiday");
        return enteredTypes;
    }

    private String locations(){
        String locations = "All";
        return locations;
    }

    private String states(){
        String states = "All";
        return states;
    }

    public Integer giveYear() {
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

    public Integer giveMonth() {
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

            if (requestedMonth < 1 && requestedMonth > 12) isInputInvalid = true;
        }
        while (isInputInvalid);

        return requestedMonth;
    }

    public Integer giveDay() {
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
        }
        while (isInputInvalid);

        return requestedDay;
    }


}
