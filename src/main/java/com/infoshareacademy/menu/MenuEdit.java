package com.infoshareacademy.menu;

import java.util.Scanner;

public class MenuEdit {
    public static void menuEdit(){
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("Choose option:\n");
        MainMenu.STDOUT.info("1. Add team\n");
        MainMenu.STDOUT.info("2. Add employee\n");
        MainMenu.STDOUT.info("3. Edit employee\n");
        MainMenu.STDOUT.info("4. Load from file\n");
        int option = scanner.nextInt();
        switch (option){
            case 1:{
                addTeam();
                break;
            }
            case 2:{
                addEmployee();
                break;
            }
            case 3:{
                editEmployee();
                break;
            }
            case 4:{
                loadFromFile();
                break;
            }
            default:{
                break;
            }
        }
    }

    private static void addTeam(){
        Scanner scanner = new Scanner(System.in);
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Add team\n");
        MainMenu.STDOUT.info("Choose option:\n");
        MainMenu.STDOUT.info("1. Add employee\n");
        MainMenu.STDOUT.info("2. Edit employee\n");
        MainMenu.STDOUT.info("3. Edit members of team(add or remove)\n");
        int option = scanner.nextInt();
        switch (option){
            case 1:{
                addEmployee();
                break;
            }
            case 2:{
                editEmployee();
                break;
            }
            case 3:{
                editMembersOfTeam();
                break;
            }
            default:{
                break;
            }
        }
    }
    private static void addTeamLeader(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Add TeamLeader");
    }
    private static void addEmployee(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Add employee");
    }
    private static void editEmployee(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Edit Employee");
    }
    private static void deleteEmplyee(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Delete employee");
    }
    private static void editMembersOfTeam(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Edit members of team");
    }
    private static void loadFromFile(){
        ClearConsole.clearConsole();
        MainMenu.STDOUT.info("Load from file");
    }
}
