package com.infoshareacademy;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * jAvalanche
 */
public class App {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
        public static void main(String[] args) throws IOException {
        STDOUT.info("jAvalanche \n");


//        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
//        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
//            String temp = holidaysJsonData.getServerResponse().getHolidays().get(i).toString();
//            STDOUT.info(temp);
//            holidaysList = (List<Holidays>) holidaysJsonData.getServerResponse().getHolidays().get(i);
//            STDOUT.info(String.valueOf(holidaysList));
//        }
//        STDOUT.info(holidaysJsonData.toString());
//            List<Holidays> holidaysList = new ArrayList<>();
//        ServerResponse serverResponse = new ServerResponse(holidaysList);
//        STDOUT.info(serverResponse.getHolidays().toString());
            HolidaysJsonData holidaysJson = new HolidaysJsonData();
            STDOUT.info(holidaysJson.printAllHolidays().toString());


    }
}
