package com.infoshareacademy.menu;

import java.util.Scanner;

public class MenuHoliday {

    public static void menuHoliday(){
        Scanner scanner = new Scanner(System.in);
        ClearConsole.clearConsole();

        MainMenu.STDOUT.info("Choose option: \n");
        MainMenu.STDOUT.info("1. Add holiday request\n");
        MainMenu.STDOUT.info("2. Cancel holiday request\n");
        MainMenu.STDOUT.info("3. Accept holiday request\n");
        MainMenu.STDOUT.info("4. Back to main menu\n");

        String option = scanner.next();
        switch (option.charAt(0)){
            case '1': {
                addHolidayRequest();
                break;
            }
            case '2': {
                cancelHolidayRequest();
                break;
            }
            case '3': {
                acceptHolidayRequest();
                break;
            }
            case '4':{
                MainMenu.mainMenu();
                break;
            }
            default:{
                menuHoliday();
                break;
            }
        }
    }

    private static void addHolidayRequest(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Add holiday request\n");
        backToMenu();
    }

    private static void cancelHolidayRequest(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Cancel holiday request\n");
        backToMenu();
    }

    private static void acceptHolidayRequest(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Accept holiday request\n");
        backToMenu();
    }

    private static void backToMenu(){
        MainMenu.STDOUT.info("Back to holiday menu press 1.\n");
        MainMenu.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1'){
            menuHoliday();
        }
        else if (option.charAt(0) == '2'){
            MainMenu.mainMenu();
        }
        else {
            backToMenu();
        }
    }
}
