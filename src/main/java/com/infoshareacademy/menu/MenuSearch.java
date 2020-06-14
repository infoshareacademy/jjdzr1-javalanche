package com.infoshareacademy.menu;

import java.util.Scanner;

public class MenuSearch {

    public void menuSearch(){
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("Choose option");
        MainMenu.STDOUT.info("1. Searching holidays");
        MainMenu.STDOUT.info("2. Searching holidays by employee");
        MainMenu.STDOUT.info("3. Searching holidays by team");
        int option = scanner.nextInt();
        switch (option){
            case 1:{
                searchingHolidays();
                break;
            }
            case 2:{
                searchingByEmployee();
                break;
            }
            case 3:{
                searchingByTeam();
                break;
            }
            default:{
                break;
            }
        }
    }

    public void searchingHolidays(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Searching holidays");
    }
    public void searchingByEmployee(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Searching holidays by employer");
    }
    public void searchingByTeam(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Searching holidays by team");
    }
}
