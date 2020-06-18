package com.infoshareacademy;

import com.infoshareacademy.menu.MainMenu;
import com.infoshareacademy.menu.MenuLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * jAvalanche
 */
public class App {
    public static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        STDOUT.info("jAvalanche \n");

        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            String temp = holidaysJsonData.getServerResponse().getHolidays().get(i).toString();
            //STDOUT.info(temp);
        }
        //STDOUT.info(holidaysJsonData.toString());
        //MenuLogin.login();

        MainMenu.mainMenu();

//        List<Holidays> allHolidayList = new ArrayList<>();
//        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
//            allHolidayList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
//        }
//        System.out.println(allHolidayList);
    }
}