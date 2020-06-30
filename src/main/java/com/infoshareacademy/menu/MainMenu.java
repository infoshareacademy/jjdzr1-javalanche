package com.infoshareacademy.menu;

import com.infoshareacademy.api.HolidaysJsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class MainMenu {

    public static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void mainMenu() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);

        String option;

        STDOUT.info("Choose option:\n");
        STDOUT.info("1. Holiday request\n");
        STDOUT.info("2. Edit\n");
        STDOUT.info("3. Searching\n");
        STDOUT.info("4. View Calendar\n");
        STDOUT.info("5. Configuration\n");
        STDOUT.info("6. Logout(back to MenuLogin)\n");

        option = scanner.next();

        switch (option.charAt(0)) {
            case '1': {
                MenuHoliday.menuHoliday();
                break;
            }
            case '2': {
                MenuEdit.menuEdit();
                break;
            }
            case '3': {
                MenuSearch.menuSearch();
                break;
            }
            case '4': {
                HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
                MenuViewHolidays.menuViewHolidays(holidaysJsonData);
                break;
            }
            case '5': {
                MenuConfiguration.menuConfiguration();
                break;
            }
            case '6':{
                MenuLogin.login();
                break;
            }
            default: {
                mainMenu();
                break;
            }
        }
    }
    private static void backToMenu(){
        MainMenu.STDOUT.info("Back to main menu press 1.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1'){
            mainMenu();
        }
        else {
            backToMenu();
        }
    }
}
