package com.infoshareacademy.menu;

import com.infoshareacademy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MainMenu {

    public static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void mainMenu(){
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        STDOUT.info("Choose option:\n");
        STDOUT.info("1. Holiday request\n");
        STDOUT.info("2. Edit\n");
        STDOUT.info("3. Searching\n");
        STDOUT.info("4. Configuration\n");
        int option = scanner.nextInt();
        switch (option){
            case 1:{
                MenuHoliday.menuHoliday();
                break;
            }
            case 2:{
                MenuEdit.menuEdit();
                break;
            }
            case 3:{
                MenuSearch.menuSearch();
                break;
            }
            case 4:{
                MenuConfiguration menuConfiguration = new MenuConfiguration();
                menuConfiguration.menuConfiguration();
                break;
            }
            default:{
                break;
            }
        }

    }
}
