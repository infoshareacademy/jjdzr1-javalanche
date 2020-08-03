package com.infoshareacademy.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.*;

public class PropertiesReader {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private String dateFormat;
    private String sortOrder;
    private InputStream inputStream;
    private Scanner scanner;
    private Properties properties;
    private String propertiesFileName = "src/main/resources/formatsConfigurations.properties";

    final private String ASCENDING_ORDER = "ASC";
    final private String DESCENDING_ORDER = "DESC";

    public PropertiesReader() {

        properties = new Properties();

        try {
            inputStream = new FileInputStream(propertiesFileName);
            properties.load(inputStream);
            this.dateFormat = properties.getProperty("dateFormat");
            this.sortOrder = properties.getProperty("sortOrder");
        } catch (Exception e) {
            STDOUT.error("Error found:" + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDateFormat() {

        properties.setProperty("dateFormat", dateInputCorrector());
        try {
            properties.store(propertiesLoader(), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dateFormat = properties.getProperty("dateFormat");
    }

    public void setSortOrder() {

        FileWriter output = propertiesLoader();

        sortingUpdatedInPropertiesFile(sortingInterface());

        try {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sortOrder = properties.getProperty("sortOrder");

        STDOUT.info("Chosen option is '" + this.sortOrder + "'.\n\n");
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public String getSortOrder() { return this.sortOrder; }

    public int usersDecisionInterpreter(Integer numberOfOptions) {

        int usersDecisionInput = 0;
        boolean isFormatIncorrect;

        STDOUT.info("Enter your decision in numbers from '1' to '" + numberOfOptions + "' input: \n");

        do {
            isFormatIncorrect = false;

            scanner = new Scanner(System.in);

            try {
                usersDecisionInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                STDOUT.error("ERROR! The decision has to be in numbers from '1' to '" + numberOfOptions + "' input: \n");
                isFormatIncorrect = true;
            }

            if (usersDecisionInput <= 0 || usersDecisionInput > numberOfOptions) {
                isFormatIncorrect = true;
                STDOUT.error("ERROR! Enter your decision in numbers from '1' to '" + numberOfOptions + "' input: \n");
            }
        }
        while (isFormatIncorrect);

        return usersDecisionInput;
    }

    private FileWriter propertiesLoader(){
        FileWriter output = null;
        try {
            output = new FileWriter(propertiesFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    private String dateInputCorrector(){

        Scanner scanner = new Scanner(System.in);
        boolean isFormatIncorrect;
        String givenDateFormat = null;

        do {
            try {
                isFormatIncorrect = false;

                STDOUT.info("Type in the date format.\n");
                givenDateFormat = scanner.nextLine();

                dateFormatValidator(givenDateFormat);

            } catch (Exception e) {
                STDOUT.error("Wrong format: " + e + "\n");
                isFormatIncorrect = true;
            }
        }
        while (isFormatIncorrect);

        return givenDateFormat;

    }

    private void dateFormatValidator(String passedDate){

        DateTimeFormatter dateTimeFormatter;

        dateTimeFormatter = DateTimeFormatter.ofPattern(passedDate);

        LocalDate currentDate = LocalDate.now();
        String exampleDate = currentDate.format(dateTimeFormatter);

        LocalDate.parse(exampleDate, dateTimeFormatter);
    }

    private void sortingUpdatedInPropertiesFile(int decision){
        if (decision == 1) {
            properties.setProperty("sortOrder", ASCENDING_ORDER);
        } else {
            properties.setProperty("sortOrder", DESCENDING_ORDER);
        }
    }

    private int sortingInterface(){

        STDOUT.info("Currently, your elements are sorted by '" + this.sortOrder + "'\n");
        STDOUT.info("Options are: \n");
        STDOUT.info("1 - " + ASCENDING_ORDER + "\n2 - " + DESCENDING_ORDER + "\n");

        return usersDecisionInterpreter(2);
    }

}
