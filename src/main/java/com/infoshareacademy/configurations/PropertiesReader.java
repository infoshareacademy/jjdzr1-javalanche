package com.infoshareacademy.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PropertiesReader {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private String dateFormat;
    private String sortOrder;
    private InputStream inputStream;
    private Scanner scanner;
    private Properties properties;
    private String propertiesFileName = "src/main/resources/formatsConfigurations.properties";

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

        scanner = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter;
        LocalDate localDate;

        boolean isFormatIncorrect;
        String givenDateFormat = null;

        do {
            try {
                isFormatIncorrect = false;

                STDOUT.info("Type in the date format.\n");
                givenDateFormat = scanner.nextLine();

                dateTimeFormatter = DateTimeFormatter.ofPattern(givenDateFormat);

                LocalDate currentDate = LocalDate.now();
                String exampleDate = currentDate.format(dateTimeFormatter);

                LocalDate.parse(exampleDate, dateTimeFormatter);

            } catch (Exception e) {
                STDOUT.error("Wrong format: " + e + "\n");
                isFormatIncorrect = true;
            }
        }
        while (isFormatIncorrect);

        FileWriter output = null;
        try {
            output = new FileWriter(propertiesFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty("dateFormat", givenDateFormat);
        try {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.dateFormat = properties.getProperty("dateFormat");
    }

    public void setSortOrder() {

        String ascendingOrder = "ASC";
        String descendingOrder = "DESC";

        STDOUT.info("Currently, your elements are sorted by '" + this.sortOrder + "'\n");
        STDOUT.info("Options are: \n");
        STDOUT.info("1 - " + ascendingOrder + "\n2 - " + descendingOrder + "\n");

        int decision = usersDecisionInterpreter(2);

        FileWriter output = null;
        try {
            output = new FileWriter(propertiesFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (decision == 1) {
            properties.setProperty("sortOrder", ascendingOrder);
        } else {
            properties.setProperty("sortOrder", descendingOrder);
        }

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

    public String getSortOrder() {
        return this.sortOrder;
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
