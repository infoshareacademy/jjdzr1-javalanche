package com.infoshareacademy.menu;

import com.infoshareacademy.api.HolidaysJsonData;
import com.infoshareacademy.api.Printer;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuViewHolidays {

    public static void menuViewHolidays(HolidaysJsonData holidaysJsonData) {
        ClearConsole.clearConsole();
        Scanner sc = new Scanner(System.in);
        MainMenu.STDOUT.info("=========================== \n");
        MainMenu.STDOUT.info("Main menu -> View calendar \n");
        MainMenu.STDOUT.info("=========================== \n");
        MainMenu.STDOUT.info("Filtering holidays by month:\n");
        MainMenu.STDOUT.info("1. View holidays\n");
        MainMenu.STDOUT.info("2. View holidays in this month\n");
        MainMenu.STDOUT.info("3. View holidays on other month\n");
        MainMenu.STDOUT.info("4. Back to main menu\n");
        String option = sc.next();
        switch (option.charAt(0)) {
            case '1': {
                Printer.getImportantInfo(holidaysJsonData);
                backToMenu(holidaysJsonData);
                break;
            }
            case '2': {
                MainMenu.STDOUT.info("========================================================== \n");
                MainMenu.STDOUT.info("Main menu -> View calendar -> View holidays in this month \n");
                MainMenu.STDOUT.info("========================================================== \n");
                if(Printer.getHolidaysInSpecifyMonth(holidaysJsonData, LocalDateTime.now().getMonthValue()).isEmpty()){
                    MainMenu.STDOUT.info("No holidays in this month \n");
                }else{
                    MainMenu.STDOUT.info(String.valueOf(Printer.getHolidaysInSpecifyMonth(holidaysJsonData, LocalDateTime.now().getMonthValue())) + "\n");
                }
                backToMenu(holidaysJsonData);
                break;
            }
            case '3': {
                String month = null;
                do {
                    MainMenu.STDOUT.info("=========================================================== \n");
                    MainMenu.STDOUT.info("Main menu -> View calendar -> View holidays in other month \n");
                    MainMenu.STDOUT.info("=========================================================== \n");
                    MainMenu.STDOUT.info("Enter a number of month to view holidays\n");
                    month = sc.next();
                } while (!(month.equals("1") || month.equals("2") || month.equals("3") ||
                        month.equals("4") || month.equals("5") || month.equals("6") ||
                        month.equals("7") || month.equals("8") || month.equals("9") ||
                        month.equals("10") || month.equals("11") || month.equals("12")));
                if(Printer.getHolidaysInSpecifyMonth(holidaysJsonData, Integer.parseInt(month)).isEmpty()){
                    MainMenu.STDOUT.info("No holidays in specify month \n");
                }else{
                    MainMenu.STDOUT.info(String.valueOf(Printer.getHolidaysInSpecifyMonth(holidaysJsonData, Integer.parseInt(month))) + "\n");
                }

                backToMenu(holidaysJsonData);
                break;
            }
            case '4': {
                MainMenu.mainMenu();
                break;
            }
            default: {
                menuViewHolidays(holidaysJsonData);
                break;
            }
        }
    }

    private static void backToMenu(HolidaysJsonData holidaysJsonData) {
        MainMenu.STDOUT.info("Back to view menu press 1.\n");
        MainMenu.STDOUT.info("Back to main menu press 2.\n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.charAt(0) == '1') {
            menuViewHolidays(holidaysJsonData);
        } else if (option.charAt(0) == '2') {
            MainMenu.mainMenu();
        } else {
            backToMenu(holidaysJsonData);
        }
    }

}
