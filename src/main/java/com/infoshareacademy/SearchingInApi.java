package com.infoshareacademy;

import com.infoshareacademy.App;
import com.infoshareacademy.Holidays;
import com.infoshareacademy.HolidaysJsonData;

import java.util.*;

public class SearchingInApi {
public static List<Holidays> searchByQuery() {
    Scanner scanner = new Scanner(System.in);

    App.STDOUT.info("Type the text you want to search by (min 3 digits): ");

    String query = scanner.nextLine();

    List<Holidays> holidaysList= new ArrayList<>();
    HolidaysJsonData holidaysJsonData = HolidaysJsonData.readDataFromJsonFile();
    if (query.length() < 3) {searchByQuery();
    } else {
        for (int i = 0; i < holidaysJsonData.getServerResponse().getHolidays().size(); i++) {
            if (holidaysJsonData.getServerResponse().getHolidays().get(i).getHolidayDate().getIso().contains(query)) {
                holidaysList.add(holidaysJsonData.getServerResponse().getHolidays().get(i));
            }
        }
    }
        App.STDOUT.info(String.valueOf(holidaysList));
        return holidaysList;
    }

}

