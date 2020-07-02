package com.infoshareacademy;

import com.infoshareacademy.edit.HolidaysEditor;
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

        MenuSearch.menuSearch();
*/

        holidaysJsonData.getServerResponse().setHolidays(HolidaysEditor.editHolidaysList(holidaysJsonData.getServerResponse().getHolidays()));


        holidaysJsonData.getServerResponse().setHolidays(HolidaysEditor.editHolidaysList(holidaysJsonData.getServerResponse().getHolidays()));


        holidaysJsonData.getServerResponse().setHolidays(HolidaysEditor.editHolidaysList(holidaysJsonData.getServerResponse().getHolidays()));
    }
}
