package com.infoshareacademy;

import com.infoshareacademy.edit.FavoriteHolidaysEditor;
import com.infoshareacademy.api.HolidaysJsonData;
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
       /* Printer.listBuilder(holidaysJsonData);
        MainMenu.mainMenu();*/

        boolean keep = true;
        while(keep){
            FavoriteHolidaysEditor.editFavoriteHolidays();
        }
    }
}
