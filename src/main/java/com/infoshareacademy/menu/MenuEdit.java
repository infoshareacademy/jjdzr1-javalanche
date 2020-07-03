package com.infoshareacademy.menu;

import com.infoshareacademy.edit.HolidaysEditor;

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
        MainMenu.STDOUT.info("4. Edit holidays\n");
        MainMenu.STDOUT.info("5. Edit favorite holidays\n");
        MainMenu.STDOUT.info("6. Load from file\n");
        MainMenu.STDOUT.info("7. Back to main menu\n");

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
                editHolidays();
                break;
            }
            case '5': {
                editFavoriteHolidays();
                break;
            }
            case '6': {
                loadFromFile();
                break;
            }
            case '7': {
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

    private static void editHolidays() {
        ClearConsole.clearConsole();

        Scanner scanner = new Scanner(System.in);
        Boolean isInputInvalid = false;
        Integer usersInput = null;

        do {

            try {
                MainMenu.STDOUT.info("================================== \n");
                MainMenu.STDOUT.info("Main menu -> Edit -> Edit holidays \n");
                MainMenu.STDOUT.info("================================== \n");
                MainMenu.STDOUT.info("Enter if you would like to:\n" +
                        "1: Create new holiday.\n" +
                        "2: Edit a holiday. \n" +
                        "3: Delete a holiday. \n" +
                        "4: Back to menu edit. \n" + "" +
                        "5: Back to main menu\n"
                );

                scanner = new Scanner(System.in);
                usersInput = scanner.nextInt();

                if (usersInput < 1 || usersInput > 5) {
                    MainMenu.STDOUT.error("Input not within required range.\n\n");
                    isInputInvalid = true;
                }
            } catch (Exception e) {
                MainMenu.STDOUT.error("Error found: " + e + "\n" + "Enter a number between 1 and 5:\n");
                isInputInvalid = true;
            }

        }
        while (isInputInvalid);

        switch (usersInput) {
            case 1:
                MainMenu.STDOUT.info("==================================================== \n");
                MainMenu.STDOUT.info("Main menu -> Edit -> Edit holidays -> Create holiday \n");
                MainMenu.STDOUT.info("==================================================== \n");
                HolidaysEditor.createElement();
                editHolidays();
                break;
            case 2:
                MainMenu.STDOUT.info("==================================================== \n");
                MainMenu.STDOUT.info("Main menu -> Edit -> Edit holidays -> Update holiday \n");
                MainMenu.STDOUT.info("==================================================== \n");
                HolidaysEditor.updateElement();
                editHolidays();
                break;
            case 3:
                MainMenu.STDOUT.info("==================================================== \n");
                MainMenu.STDOUT.info("Main menu -> Edit -> Edit holidays -> Delete holiday \n");
                MainMenu.STDOUT.info("==================================================== \n");
                HolidaysEditor.deleteElement();
                editHolidays();
                break;
            case 4:
                MenuEdit.menuEdit();
                break;
            case 5:
                MainMenu.mainMenu();
                break;
        }
    }

    private static void editFavoriteHolidays() {
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("=========================================== \n");
        MainMenu.STDOUT.info("Main menu -> Edit -> Edit favorite holidays \n");
        MainMenu.STDOUT.info("=========================================== \n");
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
