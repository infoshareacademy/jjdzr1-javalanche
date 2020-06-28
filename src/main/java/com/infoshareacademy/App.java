package com.infoshareacademy;

import com.infoshareacademy.api.HolidaysDataEditor;
import com.infoshareacademy.api.HolidaysJsonData;
import com.infoshareacademy.api.Printer;
import com.infoshareacademy.menu.MainMenu;
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
        Printer.listBuilder(holidaysJsonData);
        /*MainMenu.mainMenu();*/

        HolidaysDataEditor holidaysDataEditor = new HolidaysDataEditor();

        holidaysDataEditor.readElement();

    }
}
