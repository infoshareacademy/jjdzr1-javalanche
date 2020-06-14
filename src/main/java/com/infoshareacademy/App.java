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

        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            String temp = holidaysJsonData.getServerResponse().getHolidays().get(i).toString();
            STDOUT.info(temp);
        }
        STDOUT.info(holidaysJsonData.toString());

//        MenuLogin menuLogin = new MenuLogin();
//        menuLogin.Login();

    }
}
