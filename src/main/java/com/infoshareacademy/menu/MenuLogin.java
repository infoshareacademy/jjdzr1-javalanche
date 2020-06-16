package com.infoshareacademy.menu;
import java.util.Scanner;

public class MenuLogin {

    /*
    Metoda przygotowana do logowania użytkownika, po zalogowaniu zostanie wywołane MainMenu
     */
    public static void login(){
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        MainMenu.STDOUT.info("User:\n");
        String user = scanner.next();

        MainMenu.STDOUT.info("Password\n");
        String password = scanner.next();

        MainMenu.mainMenu();
    }
}
