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
        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        ServerResponse.getHolidays1(holidaysJsonData);
    }
}
