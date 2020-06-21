package com.infoshareacademy;

import com.infoshareacademy.api.HolidaysJsonData;
import com.infoshareacademy.api.Printer;
import com.infoshareacademy.api.ServerResponse;
import com.infoshareacademy.menu.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

/**
 * jAvalanche
 */
public class App {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) throws IOException {
        STDOUT.info("jAvalanche \n");

        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        Printer.listBuilder(holidaysJsonData);
        MainMenu.mainMenu();
    }
}
