package com.infoshareacademy.menu;

import java.util.Scanner;

public class MenuEdit {
    public static void menuEdit() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit \n");
        MainMenu.STDOUT.info("================== \n");
        MainMenu.STDOUT.info("Choose option:\n");
        MainMenu.STDOUT.info("1. Add team\n");
        MainMenu.STDOUT.info("2. Add employee\n");
        MainMenu.STDOUT.info("3. Edit employee\n");
        MainMenu.STDOUT.info("4. Load from file\n");
        MainMenu.STDOUT.info("5. Back to main menu\n");

        String option = scanner.next();
        switch (option.charAt(0)) {
            case '1': {
                addTeam();
                break;
            }
            case '2': {
                addEmployee();
                break;
            }
            case '3': {
                editEmployee();
                break;
            }
            case '4': {
                loadFromFile();
                break;
            }
            case '5': {
                MainMenu.mainMenu();
                break;
            }
            default: {
                menuEdit();
                break;
            }
        }
    }

    private static void addTeam() {
        Scanner scanner = new Scanner(System.in);
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("============================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Add team \n");
        MainMenu.STDOUT.info("============================== \n");
        MainMenu.STDOUT.info("Add team\n");
        MainMenu.STDOUT.info("Choose option:\n");
        MainMenu.STDOUT.info("1. Edit members of team(add or remove)\n");
        MainMenu.STDOUT.info("2. Add employee\n");
        MainMenu.STDOUT.info("3. Edit employee\n");
        MainMenu.STDOUT.info("4. Back to menu edit\n");
        MainMenu.STDOUT.info("5. Back to main menu\n");

        String option = scanner.next();
        switch (option.charAt(0)) {
            case '1': {
                editMembersOfTeam();
                break;
            }
            case '2': {
                addEmployee();
                break;
            }
            case '3': {
                editEmployee();
                break;
            }
            case '4': {
                menuEdit();
                break;
            }
            case '5': {
                MainMenu.mainMenu();
                break;
            }
            default: {
                addTeam();
                break;
            }
        }
    }

    private static void addTeamLeader() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("========================================================================= \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Add team -> Edit members of team -> Add team leader \n");
        MainMenu.STDOUT.info("========================================================================= \n");
        MainMenu.STDOUT.info("Add TeamLeader\n");
        backToMenu();
    }

    private static void addEmployee() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("================================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Add employee \n");
        MainMenu.STDOUT.info("================================== \n");
        MainMenu.STDOUT.info("Add employee\n");
        backToMenu();
    }

    private static void editEmployee() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        MainMenu.STDOUT.info("=================================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Edit employee \n");
        MainMenu.STDOUT.info("=================================== \n");
        MainMenu.STDOUT.info("Edit Employee\n");
        MainMenu.STDOUT.info("To delete employee press 1.\n");

        String option = scanner.next();
        if (option.charAt(0) == '1') {
            deleteEmployee();
        } else {
            editEmployee();
        }
        backToMenu();
    }

    private static void deleteEmployee() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("====================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Edit employee -> Delete employee \n");
        MainMenu.STDOUT.info("====================================================== \n");
        MainMenu.STDOUT.info("Delete employee\n");
        backToMenu();
    }

    private static void editMembersOfTeam() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        MainMenu.STDOUT.info("====================================================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Add team -> Edit members of team \n");
        MainMenu.STDOUT.info("====================================================== \n");
        MainMenu.STDOUT.info("Edit members of team\n");
        MainMenu.STDOUT.info("1. Add TeamLeader\n");
        String option = scanner.next();

        if (option.charAt(0) == '1') {
            addTeamLeader();
        } else {
            editMembersOfTeam();
        }
        backToMenu();
    }

    private static void loadFromFile() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("==================================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Load from file \n");
        MainMenu.STDOUT.info("==================================== \n");
        MainMenu.STDOUT.info("Load from file \n");
        backToMenu();
    }

    private static void backToMenu() {
        MainMenu.STDOUT.info("Back to edit menu press 1.\n");
        MainMenu.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
            menuEdit();
        } else if (option.charAt(0) == '2') {
            MainMenu.mainMenu();
        } else {
            backToMenu();
        }
    }
}
