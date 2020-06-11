package com.infoshareacademy.configurations;

import java.io.IOException;

import static com.infoshareacademy.configurations.PropertiesReader.sortCategory;

public class PropertiesOperator {

    public static void checkProperties() throws IOException {

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

        PropertiesReader propRead = new PropertiesReader();

        System.out.println(propRead.toString() + "\n");

        propRead.setSortCategory(sortCategories);
        propRead.setDateFormat(dateFormats);
        propRead.setSortOrder(sortOrders);

        System.out.println(propRead.toString());

        System.out.println(sortCategory);
    }
}
