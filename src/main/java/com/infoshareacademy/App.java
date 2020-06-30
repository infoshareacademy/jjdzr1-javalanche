package com.infoshareacademy;

import com.infoshareacademy.api.HolidaysEditor;
import com.infoshareacademy.api.HolidaysJsonData;
import com.infoshareacademy.api.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * jAvalanche
 */
public class App {
    public static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        STDOUT.info("jAvalanche \n");

        HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
        Printer.listBuilder(holidaysJsonData);
        /*MainMenu.mainMenu();*/

        HolidaysEditor holidaysEditor = new HolidaysEditor(holidaysJsonData);

        holidaysEditor.createElement();

    }
}
