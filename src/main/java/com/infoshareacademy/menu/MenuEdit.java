package com.infoshareacademy.menu;

import com.infoshareacademy.edit.FavoriteHolidaysEditor;
import com.infoshareacademy.edit.HolidaysEditor;

import java.util.Scanner;

import static com.infoshareacademy.App.STDOUT;

public class MenuEdit {
    public static void menuEdit() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MenuMain.STDOUT.info("================== \n");
        MenuMain.STDOUT.info("Main menu -> Edit \n");
        MenuMain.STDOUT.info("================== \n");
        MenuMain.STDOUT.info("Choose option:\n");
        MenuMain.STDOUT.info("1. Add team\n");
        MenuMain.STDOUT.info("2. Add employee\n");
        MenuMain.STDOUT.info("3. Edit employee\n");
        MenuMain.STDOUT.info("4. Edit holidays\n");
        MenuMain.STDOUT.info("5. Edit favorite holidays\n");
        MenuMain.STDOUT.info("6. Load from file\n");
        MenuMain.STDOUT.info("7. Back to main menu\n");

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
                MenuMain.mainMenu();
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
        MenuMain.STDOUT.info("============================== \n");
        MenuMain.STDOUT.info("Main menu -> Edit -> Add team \n");
        MenuMain.STDOUT.info("============================== \n");
        MenuMain.STDOUT.info("Add team\n");
        MenuMain.STDOUT.info("Choose option:\n");
        MenuMain.STDOUT.info("1. Edit members of team(add or remove)\n");
        MenuMain.STDOUT.info("2. Add employee\n");
        MenuMain.STDOUT.info("3. Edit employee\n");
        MenuMain.STDOUT.info("4. Back to menu edit\n");
        MenuMain.STDOUT.info("5. Back to main menu\n");

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
                MenuMain.mainMenu();
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
        MenuMain.STDOUT.info("========================================================================= \n");
        MenuMain.STDOUT.info("Main menu -> Edit -> Add team -> Edit members of team -> Add team leader \n");
        MenuMain.STDOUT.info("========================================================================= \n");
        MenuMain.STDOUT.info("Add TeamLeader\n");
        backToMenu();
    }

    private static void addEmployee() {
        ClearConsole.clearConsole();
        MenuMain.STDOUT.info("================================== \n");
        MenuMain.STDOUT.info("Main menu -> Edit -> Add employee \n");
        MenuMain.STDOUT.info("================================== \n");
        MenuMain.STDOUT.info("Add employee\n");
        backToMenu();
    }

    private static void editEmployee() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        MenuMain.STDOUT.info("=================================== \n");
        MenuMain.STDOUT.info("Main menu -> Edit -> Edit employee \n");
        MenuMain.STDOUT.info("=================================== \n");
        MenuMain.STDOUT.info("Edit Employee\n");
        MenuMain.STDOUT.info("To delete employee press 1.\n");

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
        MenuMain.STDOUT.info("====================================================== \n");
        MenuMain.STDOUT.info("Main menu -> Edit -> Edit employee -> Delete employee \n");
        MenuMain.STDOUT.info("====================================================== \n");
        MenuMain.STDOUT.info("Delete employee\n");
        backToMenu();
    }

    private static void editMembersOfTeam() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        MenuMain.STDOUT.info("====================================================== \n");
        MenuMain.STDOUT.info("Main menu -> Edit -> Add team -> Edit members of team \n");
        MenuMain.STDOUT.info("====================================================== \n");
        MenuMain.STDOUT.info("Edit members of team\n");
        MenuMain.STDOUT.info("1. Add TeamLeader\n");
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
        Boolean isInputInvalid;
        Integer usersInput = null;

        do {
            isInputInvalid = false;

            try {
                MenuMain.STDOUT.info("================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit holidays \n");
                MenuMain.STDOUT.info("================================== \n");
                MenuMain.STDOUT.info("Enter if you would like to:\n" +
                        "1: Create new holiday.\n" +
                        "2: Edit a holiday. \n" +
                        "3: Delete a holiday. \n" +
                        "4: Back to menu edit. \n" +
                        "5: Back to main menu\n"
                );

                scanner = new Scanner(System.in);
                usersInput = scanner.nextInt();
                STDOUT.info("\n");

                if (usersInput < 1 || usersInput > 5) {
                    MenuMain.STDOUT.error("Input not within required range.\n\n");
                    isInputInvalid = true;
                }
            } catch (Exception e) {
                MenuMain.STDOUT.error("Error found: " + e + "\n" + "Enter a number between 1 and 5:\n");
                isInputInvalid = true;
            }

        }
        while (isInputInvalid);

        switch (usersInput) {
            case 1:
                MenuMain.STDOUT.info("==================================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit holidays -> Create holiday \n");
                MenuMain.STDOUT.info("==================================================== \n");
                HolidaysEditor.createElement();
                editHolidays();
                break;
            case 2:
                MenuMain.STDOUT.info("==================================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit holidays -> Update holiday \n");
                MenuMain.STDOUT.info("==================================================== \n");
                HolidaysEditor.updateElement();
                editHolidays();
                break;
            case 3:
                MenuMain.STDOUT.info("==================================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit holidays -> Delete holiday \n");
                MenuMain.STDOUT.info("==================================================== \n");
                HolidaysEditor.deleteElement();
                editHolidays();
                break;
            case 4:
                MenuEdit.menuEdit();
                break;
            case 5:
                MenuMain.mainMenu();
                break;
        }
    }

    private static void editFavoriteHolidays() {
        ClearConsole.clearConsole();

        Scanner scanner = new Scanner(System.in);
        Boolean isInputInvalid;
        Integer usersInput = null;

        do {
            isInputInvalid = false;

            try {
                MenuMain.STDOUT.info("=========================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit favorite holidays \n");
                MenuMain.STDOUT.info("=========================================== \n");
                STDOUT.info("Enter if you would like to:\n" +
                        "1: Print favorite holidays.\n" +
                        "2: Add a favorite holiday. \n" +
                        "3: Remove a holiday.\n" +
                        "4: Back to menu edit. \n" +
                        "5: Back to main menu\n");

                scanner = new Scanner(System.in);
                usersInput = scanner.nextInt();
                STDOUT.info("\n");

                if (usersInput < 1 || usersInput > 5) {
                    STDOUT.error("Input not within required range.\n\n");
                    isInputInvalid = true;
                }
            } catch (Exception e) {
                STDOUT.error("Error found: " + e + "\n" + "Enter a number between 1 and 5:\n");
                isInputInvalid = true;
            }

        }
        while (isInputInvalid);

        switch (usersInput) {
            case 1:
                MenuMain.STDOUT.info("====================================================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit favorite holidays -> Print favorite holidays \n");
                MenuMain.STDOUT.info("====================================================================== \n");
                FavoriteHolidaysEditor.printFavoriteHolidays();
                editFavoriteHolidays();
                break;
            case 2:
                MenuMain.STDOUT.info("=================================================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit favorite holidays -> Add favorite holiday \n");
                MenuMain.STDOUT.info("=================================================================== \n");
                FavoriteHolidaysEditor.addFavoriteHolidays();
                editFavoriteHolidays();
                break;
            case 3:
                MenuMain.STDOUT.info("====================================================================== \n");
                MenuMain.STDOUT.info("Main menu -> Edit -> Edit favorite holidays -> Remove favorite holiday \n");
                MenuMain.STDOUT.info("====================================================================== \n");
                FavoriteHolidaysEditor.removeFavoriteHolidays();
                editFavoriteHolidays();
                break;
            case 4:
                MenuEdit.menuEdit();
                break;
            case 5:
                MenuMain.mainMenu();
        }
    }

    private static void loadFromFile() {
        ClearConsole.clearConsole();
        MenuMain.STDOUT.info("==================================== \n");
        MenuMain.STDOUT.info("Main menu -> Edit -> Load from file \n");
        MenuMain.STDOUT.info("==================================== \n");
        MenuMain.STDOUT.info("Load from file \n");
        backToMenu();
    }

    private static void backToMenu() {
        MenuMain.STDOUT.info("Back to edit menu press 1.\n");
        MenuMain.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
            menuEdit();
        } else if (option.charAt(0) == '2') {
            MenuMain.mainMenu();
        } else {
            backToMenu();
        }
    }
}
