package com.infoshareacademy;

import com.infoshareacademy.configurations.PropertiesReader;
import com.infoshareacademy.menu.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * jAvalanche
 */
public class App {
    public static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) throws IOException {
        STDOUT.info("jAvalanche \n");

        MainMenu.mainMenu();

    }
}