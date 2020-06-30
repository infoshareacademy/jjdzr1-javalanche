package com.infoshareacademy;

import com.infoshareacademy.api.HolidaysEditor;
import com.infoshareacademy.api.HolidaysJsonData;
import com.infoshareacademy.api.Printer;
import com.infoshareacademy.menu.MainMenu;
import com.infoshareacademy.menu.MenuSearch;
import com.infoshareacademy.search.SearchingInApi;
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

        MenuSearch.menuSearch();

        //HolidaysEditor holidaysEditor = new HolidaysEditor(holidaysJsonData);

/*

        System.out.println("\n\n\n\n\n\nCREATE ELEMENT");
        holidaysEditor.createElement();
        System.out.println("CHECK\n");
        holidaysEditor.printElement();
        System.out.println("CHECK\n");

        System.out.println("\n\n\n\n\n\nREAD ELEMENT");
        holidaysEditor.readElement();
        System.out.println("CHECK\n");
        holidaysEditor.printElement();
        System.out.println("CHECK\n");

        System.out.println("\n\n\n\n\n\nUPDATE ELEMENT");
        holidaysEditor.updateElement();
        System.out.println("CHECK\n");
        holidaysEditor.printElement();
        System.out.println("CHECK\n");
*/
/*
        System.out.println("\n\n\n\n\n\nDELETE ELEMENT");
        holidaysEditor.deleteElement();
        System.out.println("CHANGED LIST\n");
        holidaysEditor.printElement();*/



    }
}
