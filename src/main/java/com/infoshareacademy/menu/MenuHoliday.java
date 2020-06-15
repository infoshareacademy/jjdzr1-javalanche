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
        int option = scanner.nextInt();
        switch (option){
            case 1: {
                addHolidayRequest();
                break;
            }
            case 2: {
                cancelHolidayRequest();
                break;
            }
            case 3: {
                acceptHolidayRequest();
                break;
            }
            default:{
                break;
            }
        }
    }

    private static void addHolidayRequest(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Add holiday request");
    }

    private static void cancelHolidayRequest(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Cancel holiday request");
    }

    private static void acceptHolidayRequest(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Accept holiday request");
    }
}
