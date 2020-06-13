package com.infoshareacademy;

import sun.rmi.rmic.Main;

import java.util.Scanner;

public class UserLogin {
    public void userLogin(){
        Scanner scanner = new Scanner(System.in);
        MainMenu.STDOUT.info("User:");
        String user = scanner.next();
        MainMenu.STDOUT.info("Password");
        String password = scanner.next();
    }
}
