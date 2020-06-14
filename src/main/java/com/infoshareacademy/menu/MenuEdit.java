package com.infoshareacademy.menu;

import com.infoshareacademy.App;
import com.infoshareacademy.menu.MainMenu;

import java.util.Scanner;

public class MenuEdit {
    public void menuEdit(){
        App.clearConsole();
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

    public void addTeam(){
        Scanner scanner = new Scanner(System.in);
        App.clearConsole();
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
    public void addTeamLeader(){
        App.clearConsole();
        MainMenu.STDOUT.info("Add TeamLeader");
    }
    public void addEmployee(){
        App.clearConsole();
        MainMenu.STDOUT.info("Add employee");
    }
    public void editEmployee(){
        App.clearConsole();
        MainMenu.STDOUT.info("Edit Employee");
    }
    public void deleteEmplyee(){
        App.clearConsole();
        MainMenu.STDOUT.info("Delete employee");
    }
    public void editMembersOfTeam(){
        App.clearConsole();
        MainMenu.STDOUT.info("Edit members of team");
    }
    public void loadFromFile(){
        App.clearConsole();
        MainMenu.STDOUT.info("Load from file");
    }
}
