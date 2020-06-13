package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainMenu {

    public static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public void mainMenu(){
        STDOUT.info("Choose option:\n");
        STDOUT.info("1. Holiday request\n");
        STDOUT.info("2. Edit\n");
        STDOUT.info("3. Searching\n");
        STDOUT.info("4. Configuration\n");
    }
}
