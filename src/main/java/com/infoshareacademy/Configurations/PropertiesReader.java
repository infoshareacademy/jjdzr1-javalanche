package com.infoshareacademy.Configurations;

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

    String dateFormat;
    String sortOrder;

    InputStream inputStream;
    Scanner scanner;

    Properties properties;
    String propertiesFileName = "src/main/resources/formatsConfigurations.properties";

    public PropertiesReader() throws IOException {

        try {
            properties = new Properties();

            inputStream = new FileInputStream(propertiesFileName);

            if (inputStream != null) {
                properties.load(inputStream);

                this.properties = properties;
            } else {
                throw new FileNotFoundException("File at '" + propertiesFileName + "' has not been found.");
            }

            this.dateFormat = properties.getProperty("dateFormat");
            this.sortOrder = properties.getProperty("sortOrder");
        } catch (Exception e) {
            STDOUT.error("Error found:" + e);
        } finally {
            inputStream.close();
        }
    }

    public void setDateFormat() throws IOException {

        scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter;
        LocalDate localDate;

        boolean isFormatIncorrect = false;
        String givenDateFormat = null;

        do {
            try {
                isFormatIncorrect = false;

                STDOUT.info("Type in the date format.\n");
                givenDateFormat = scanner.nextLine();

                dateTimeFormatter = DateTimeFormatter.ofPattern(givenDateFormat);

                LocalDate currentDate = LocalDate.now();
                String exampleDate = currentDate.format(dateTimeFormatter);

                LocalDate parseExample = LocalDate.parse(exampleDate, dateTimeFormatter);

            } catch (IllegalArgumentException | UnsupportedTemporalTypeException | DateTimeParseException e) {
                STDOUT.error("Wrong format: " + e + "\n");
                isFormatIncorrect = true;
            }
        }
        while (isFormatIncorrect);

        FileWriter output = new FileWriter(propertiesFileName);

        properties.setProperty("dateFormat", givenDateFormat);
        properties.store(output, null);
        this.dateFormat = properties.getProperty("dateFormat");
    }

    public void setSortOrder() throws IOException {

        String ascendingOrder = "ASC";
        String descendingOrder = "DESC";

        STDOUT.info("Currently, your elements are sorted by '" + this.sortOrder + "'\n");
        STDOUT.info("Options are: \n");
        STDOUT.info("1 - " + ascendingOrder + "\n2 - " + descendingOrder + "\n");

        int decision = usersDecisionInterpreter(2);

        FileWriter output = new FileWriter(propertiesFileName);

        if (decision == 1) {
            properties.setProperty("sortOrder", ascendingOrder);
        } else {
            properties.setProperty("sortOrder", descendingOrder);
        }

        properties.store(output, null);
        this.sortOrder = properties.getProperty("sortOrder");

        STDOUT.info("Chosen option is '" + this.sortOrder + "'.\n\n");
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    @Override
    public String toString() {
        return "Chosen options are: {" +
                ", dateFormat='" + dateFormat + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }

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

    public String getKeyProperty(String keyTitle) throws IOException {

        String requestedProperty = null;

        try {
            properties = new Properties();

            inputStream = new FileInputStream(propertiesFileName);

            if (inputStream != null) {
                properties.load(inputStream);

            } else {
                throw new FileNotFoundException("File at '" + propertiesFileName + "' has not been found.");
            }

            requestedProperty = properties.getProperty(keyTitle);
        } catch (Exception e) {
            STDOUT.error("Error found:" + e);
        } finally {
            inputStream.close();
        }

        if (requestedProperty == null) {
            requestedProperty = "";
            STDOUT.error("Given key doesn't find any match.");
        }
        return requestedProperty;

    }
}
