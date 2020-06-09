package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jAvalanche
 */
public class App {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        STDOUT.info("jAvalanche \n");

        HolidaysJSONData holidaysJSONData = HolidaysJSONData.readDataFromJsonFile();
        for (int i = 0; i < holidaysJSONData.getServerResponse().getHolidays().size(); i++) {
            String temp = holidaysJSONData.getServerResponse().getHolidays().get(i).toString();
            STDOUT.info(temp);
        }
        STDOUT.info(holidaysJSONData.toString());
    }
}
