package com.infoshareacademy.configurations;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] sortCategories = new String[2];
        String[] sortOrders = new String[2];
        String[] dateFormats = new String[3];

        sortCategories[0] = "Name";
        sortCategories[1] = "Date";
        sortOrders[0] = "ASC";
        sortOrders[1] = "DESC";
        dateFormats[0] = "ddMMyyyy";
        dateFormats[1] = "MMddyyyy";
        dateFormats[2] = "yyyyMMdd";

        PropertiesReader propertiesReader = new PropertiesReader();

        System.out.println(propertiesReader.toString() + "\n");

        propertiesReader.setSortCategory(sortCategories);
        propertiesReader.setDateFormat(dateFormats);
        propertiesReader.setSortOrder(sortOrders);

        System.out.println("\n" + propertiesReader.toString());

    }
}
