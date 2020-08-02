package com.infoshareacademy.menu;

import java.util.Scanner;

public class MenuLogin {

    public static void login() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        MenuMain.STDOUT.info("====== \n");
        MenuMain.STDOUT.info("LOGIN \n");
        MenuMain.STDOUT.info("====== \n");
        MenuMain.STDOUT.info("User:\n");
        String user = scanner.next();

        MenuMain.STDOUT.info("Password\n");
        String password = scanner.next();

        MenuMain.mainMenu();
    }
}
