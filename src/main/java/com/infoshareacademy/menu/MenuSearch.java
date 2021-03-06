package com.infoshareacademy.menu;

import com.infoshareacademy.search.SearchingInApi;
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MenuSearch {

    public static void menuSearch() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("==================== \n");
        MainMenu.STDOUT.info("Main menu -> Search \n");
        MainMenu.STDOUT.info("==================== \n");
        MainMenu.STDOUT.info("Choose option\n");
        MainMenu.STDOUT.info("1. Searching holidays\n");
        MainMenu.STDOUT.info("2. Searching holidays by employee\n");
        MainMenu.STDOUT.info("3. Searching holidays by team\n");
        MainMenu.STDOUT.info("4. Back to main menu\n");

        String option = scanner.next();
        switch (option.charAt(0)) {
            case '1': {
                searchingHolidays();
                break;
            }
            case '2': {
                searchingByEmployee();
                break;
            }
            case '3': {
                searchingByTeam();
                break;
            }
            case '4': {
                MainMenu.mainMenu();
                break;
            }
            default: {
                menuSearch();
                break;
            }
        }
    }

    public static void searchingHolidays() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("========================================== \n");
        MainMenu.STDOUT.info("Main menu -> Search -> Searching holidays \n");
        MainMenu.STDOUT.info("========================================== \n");
        MainMenu.STDOUT.info("Choose searching option: \n");
        MainMenu.STDOUT.info("1. Search by name: \n");
        MainMenu.STDOUT.info("2. Search by description: \n");
        MainMenu.STDOUT.info("3. Search by date: \n");
        MainMenu.STDOUT.info("4. Search by name and date: \n");
        MainMenu.STDOUT.info("5. Back to menu search \n");
        MainMenu.STDOUT.info("6. Back to main menu \n");

        String option = scanner.next();
        switch (option.charAt(0)) {
            case '1': {
                SearchingInApi.searchByName();
                break;
            }
            case '2': {
                SearchingInApi.searchByDescr();
                break;
            }
            case '3': {
                SearchingInApi.searchByDate();
                break;
            }
            case '4': {
                SearchingInApi.searchByNameAndDate();
                break;
            }
            case '5': {
                menuSearch();
                break;
            }
            case '6': {
                MainMenu.mainMenu();
            }
            default: {
                searchingHolidays();
                break;
            }
        }
    }

    private static void searchingByEmployee() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("====================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Search -> Searching holidays by employee \n");
        MainMenu.STDOUT.info("====================================================== \n");
        MainMenu.STDOUT.info("Searching holidays by employee\n");
        backToMenu();
    }

    private static void searchingByTeam() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Search -> Searching holidays by team \n");
        MainMenu.STDOUT.info("================================================== \n");
        MainMenu.STDOUT.info("Searching holidays by team\n");
        backToMenu();
    }
// methods to be removed - replaced by methods in SearchingInApi class
    /* private static void searchHolidaysByName() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("=============================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Search -> Searching holidays -> Searching by name \n");
        MainMenu.STDOUT.info("=============================================================== \n");
        MainMenu.STDOUT.info("Searching by name\n");
        backToMenu();
    }

    private static void searchHolidaysByDescription() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("====================================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Search -> Searching holidays -> Searching by description  \n");
        MainMenu.STDOUT.info("====================================================================== \n");
        MainMenu.STDOUT.info("Searching by description\n");
        backToMenu();
    }

    private static void searchHolidaysByDate() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("=============================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Search -> Searching holidays -> Searching by date  \n");
        MainMenu.STDOUT.info("=============================================================== \n");
        MainMenu.STDOUT.info("Searching by date\n");
        backToMenu();
    }

    private static void searchHolidaysByNameAndDate() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("======================================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Search -> Searching holidays -> Searching by name and date  \n");
        MainMenu.STDOUT.info("======================================================================== \n");
        MainMenu.STDOUT.info("Searching by name and date: \n");
        backToMenu();
    } */

    public static void backToMenu() {
        MainMenu.STDOUT.info("Back to search menu press 1.\n");
        MainMenu.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
            menuSearch();
        } else if (option.charAt(0) == '2') {
            MainMenu.mainMenu();
        } else {
            backToMenu();
        }
    }

}
