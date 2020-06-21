package com.infoshareacademy.menu;
import java.util.Scanner;

public class MenuSearch {

    public static void menuSearch() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        MainMenu.STDOUT.info("Choose option\n");
        MainMenu.STDOUT.info("1. Searching holidays\n");
        MainMenu.STDOUT.info("2. Searching holidays by employee\n");
        MainMenu.STDOUT.info("3. Searching holidays by team\n");
        MainMenu.STDOUT.info("4. Back to main menu\n");

        String option = scanner.next();
        switch (option.charAt(0)){
            case '1':{
                searchingHolidays();
                break;
            }
            case '2':{
                searchingByEmployee();
                break;
            }
            case '3':{
                searchingByTeam();
                break;
            }
            case '4':{
                MainMenu.mainMenu();
                break;
            }
            default:{
                menuSearch();
                break;
            }
        }
    }

    private static void searchingHolidays() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Searching holidays");
        backToMenu();
    }
    private static void searchingByEmployee() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Searching holidays by employer");
        backToMenu();
    }
    private static void searchingByTeam() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Searching holidays by team");
        backToMenu();
    }
    private static void backToMenu() {
        MainMenu.STDOUT.info("Back to search menu press 1.\n");
        MainMenu.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1'){
            menuSearch();
        }
        else if (option.charAt(0) == '2'){
            MainMenu.mainMenu();
        }
        else {
            backToMenu();
        }
    }

}
