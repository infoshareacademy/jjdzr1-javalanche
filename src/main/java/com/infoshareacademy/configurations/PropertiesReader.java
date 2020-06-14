package com.infoshareacademy.configurations;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesReader {

    String sortCategory;
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

            this.sortCategory = properties.getProperty("sortCategory");
            this.dateFormat = properties.getProperty("dateFormat");
            this.sortOrder = properties.getProperty("sortOrder");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    public void setSortCategory(String[] sortCategoryOptions) throws IOException {

        System.out.println("Currently, your elements are sorted by " + this.sortCategory);
        System.out.println("Options are: ");
        for (int index = 0; index < sortCategoryOptions.length; index++) {
            System.out.println("-" + sortCategoryOptions[index]);
        }

        scanner = new Scanner(System.in);

        System.out.println("Enter your decision:");
        Integer decision = scanner.nextInt();

        FileWriter output = new FileWriter(propertiesFileName);

        if (decision == 1) {
            properties.setProperty("sortCategory", sortCategoryOptions[0]);
        } else {
            properties.setProperty("sortCategory", sortCategoryOptions[1]);
        }

        properties.store(output, null);
        this.sortCategory = properties.getProperty("sortCategory");

        System.out.println(this.sortCategory);

    }

    public void setDateFormat(String[] dateFormatOptions) throws IOException {

        System.out.println("Currently, your elements are sorted by " + this.dateFormat);
        System.out.println("Options are: ");
        for (int index = 0; index < dateFormatOptions.length; index++) {
            System.out.println("-" + dateFormatOptions[index]);
        }

        scanner = new Scanner(System.in);

        System.out.println("Enter your decision:");
        Integer decision = scanner.nextInt();

        FileWriter output = new FileWriter(propertiesFileName);

        if (decision == 1) {
            properties.setProperty("dateFormat", dateFormatOptions[0]);
        } else if (decision == 2) {
            properties.setProperty("dateFormat", dateFormatOptions[1]);
        } else {
            properties.setProperty("dateFormat", dateFormatOptions[2]);
        }

        properties.store(output, null);
        this.dateFormat = properties.getProperty("dateFormat");

        System.out.println(this.dateFormat);

    }

    public void setSortOrder(String[] sortOrderOptions) throws IOException {

        String sortOrder = properties.getProperty("sortCategory");

        System.out.println("Currently, your elements are sorted by " + this.sortOrder);
        System.out.println("Options are: ");
        for (int index = 0; index < sortOrderOptions.length; index++) {
            System.out.println("-" + sortOrderOptions[index]);
        }

        scanner = new Scanner(System.in);

        System.out.println("Enter your decision:");
        Integer decision = scanner.nextInt();

        FileWriter output = new FileWriter(propertiesFileName);

        if (decision == 1) {
            properties.setProperty("sortOrder", sortOrderOptions[0]);
        } else {
            properties.setProperty("sortOrder", sortOrderOptions[1]);
        }

        properties.store(output, null);
        this.sortOrder = properties.getProperty("sortOrder");

        System.out.println(this.sortOrder);

    }

    public String getSortCategory() {
        return this.sortCategory;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    @Override
    public String toString() {
        return "PropertiesReader{" +
                "sortCategory='" + sortCategory + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }
}
