package com.infoshareacademy.menu;

import com.infoshareacademy.configurations.PropertiesReader;

import java.io.IOException;
import java.util.Scanner;

public class MenuConfiguration {

    private static PropertiesReader propertiesReader = new PropertiesReader();

    public static void menuConfiguration() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        MainMenu.STDOUT.info("Choose option\n");
        MainMenu.STDOUT.info("1. Load from file\n");
        MainMenu.STDOUT.info("2. Sorting(ASC/DESC)\n");
        MainMenu.STDOUT.info("3. Date format\n");
        MainMenu.STDOUT.info("4. Back to main menu\n");

        String option = scanner.next();
        switch (option.charAt(0)) {
            case '1': {
                loadFromFile();
                break;
            }
            case '2': {
                sorting();
                break;
            }
            case '3': {
                dateFormat();
                break;
            }
            case '4': {
                MainMenu.mainMenu();
                break;
            }
            default: {
                menuConfiguration();
                break;
            }
        }
    }

    private static void loadFromFile() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Load from file\n");
        backToMenu();
    }

    private static void sorting() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Sorting ASC/DESC\n");
        propertiesReader.setSortOrder();
        backToMenu();
    }

    private static void dateFormat() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Date Format\n");
        propertiesReader.setDateFormat();
        backToMenu();
    }

    private static void backToMenu() {
        MainMenu.STDOUT.info("Back to configuration menu press 1.\n");
        MainMenu.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
            menuConfiguration();
        } else if (option.charAt(0) == '2') {
            MainMenu.mainMenu();
        } else {
            backToMenu();
        }
    }
}
