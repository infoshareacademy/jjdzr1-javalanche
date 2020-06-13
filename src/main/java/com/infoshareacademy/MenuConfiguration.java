package com.infoshareacademy;

import sun.rmi.rmic.Main;

import java.util.Scanner;

public class MenuConfiguration {

    public void menuConfiguration(){
        App.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("Choose option\n");
        MainMenu.STDOUT.info("1. Load from file\n");
        MainMenu.STDOUT.info("2. Sorting(ASC/DESC)\n");
        MainMenu.STDOUT.info("3. Date format\n");
        int option = scanner.nextInt();
        switch (option){
            case 1:{

            }
            case 2:{

            }
            case 3:{

            }
            default:{
                break;
            }
        }
    }

    public void loadFromFile(){
        App.clearConsole();
        MainMenu.STDOUT.info("Load from file");
    }
    public void sorting(){
        App.clearConsole();
        MainMenu.STDOUT.info("Sorting ASC/DESC");
    }
    public void dateFormat(){
        App.clearConsole();
        MainMenu.STDOUT.info("Date Format");
    }
}
