package com.infoshareacademy;

import com.infoshareacademy.configurations.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * jAvalanche
 */
public class App {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) throws IOException {
        STDOUT.info("jAvalanche \n");

        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            String temp = holidaysJsonData.getServerResponse().getHolidays().get(i).toString();
            STDOUT.info(temp);
        }
        STDOUT.info(holidaysJsonData.toString());

        PropertiesReader propertiesReader = new PropertiesReader();

        System.out.println(propertiesReader.getDateFormat());


    }
}
