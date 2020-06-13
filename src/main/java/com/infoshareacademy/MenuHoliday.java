package com.infoshareacademy;

import java.util.Scanner;

public class MenuHoliday {

    public void menuHoliday(){
        Scanner scanner = new Scanner(System.in);
        App.clearConsole();
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
            default: break;
        }
    }

    public void addHolidayRequest(){
        App.clearConsole();
        MainMenu.STDOUT.info("Add holiday request");
    }

    public void cancelHolidayRequest(){
        App.clearConsole();
        MainMenu.STDOUT.info("Cancel holiday request");
    }

    public void acceptHolidayRequest(){
        App.clearConsole();
        MainMenu.STDOUT.info("Accept holiday request");
    }
}
