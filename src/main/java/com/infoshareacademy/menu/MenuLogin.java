package com.infoshareacademy.menu;

import com.infoshareacademy.App;

import java.util.Scanner;

public class MenuLogin {
    public void Login(){
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("User:");
        String user = scanner.next();
        MainMenu.STDOUT.info("Password");
        String password = scanner.next();
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
    }
}
