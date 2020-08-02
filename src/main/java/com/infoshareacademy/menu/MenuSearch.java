package com.infoshareacademy.menu;

import com.infoshareacademy.search.SearchingInApi;
import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MenuSearch {

    public static void menuSearch() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MenuMain.STDOUT.info("==================== \n");
        MenuMain.STDOUT.info("Main menu -> Search \n");
        MenuMain.STDOUT.info("==================== \n");
        MenuMain.STDOUT.info("Choose option\n");
        MenuMain.STDOUT.info("1. Searching holidays\n");
        MenuMain.STDOUT.info("2. Searching holidays by employee\n");
        MenuMain.STDOUT.info("3. Searching holidays by team\n");
        MenuMain.STDOUT.info("4. Back to main menu\n");

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
                MenuMain.mainMenu();
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
        MenuMain.STDOUT.info("========================================== \n");
        MenuMain.STDOUT.info("Main menu -> Search -> Searching holidays \n");
        MenuMain.STDOUT.info("========================================== \n");
        MenuMain.STDOUT.info("Choose searching option: \n");
        MenuMain.STDOUT.info("1. Search by name: \n");
        MenuMain.STDOUT.info("2. Search by description: \n");
        MenuMain.STDOUT.info("3. Search by date: \n");
        MenuMain.STDOUT.info("4. Search by name and date: \n");
        MenuMain.STDOUT.info("5. Back to menu search \n");
        MenuMain.STDOUT.info("6. Back to main menu \n");

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
                MenuMain.mainMenu();
            }
            default: {
                searchingHolidays();
                break;
            }
        }
    }

    private static void searchingByEmployee() {
        ClearConsole.clearConsole();
        MenuMain.STDOUT.info("====================================================== \n");
        MenuMain.STDOUT.info("Main menu -> Search -> Searching holidays by employee \n");
        MenuMain.STDOUT.info("====================================================== \n");
        MenuMain.STDOUT.info("Searching holidays by employee\n");
        backToMenu();
    }

    private static void searchingByTeam() {
        ClearConsole.clearConsole();
        MenuMain.STDOUT.info("================================================== \n");
        MenuMain.STDOUT.info("Main menu -> Search -> Searching holidays by team \n");
        MenuMain.STDOUT.info("================================================== \n");
        MenuMain.STDOUT.info("Searching holidays by team\n");
        backToMenu();
    }

    public static void backToMenu() {
        MenuMain.STDOUT.info("Back to search menu press 1.\n");
        MenuMain.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
            menuSearch();
        } else if (option.charAt(0) == '2') {
            MenuMain.mainMenu();
        } else {
            backToMenu();
        }
    }

}
