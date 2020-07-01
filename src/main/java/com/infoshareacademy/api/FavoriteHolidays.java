package com.infoshareacademy.api;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FavoriteHolidays {

    private List<Holidays> allHolidaysList = HolidaysJsonData.readDataFromJsonFile().getServerResponse().getHolidays();
    private List<Holidays> favoriteHolidaysList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addFavoriteHolidays(){}

    public void removeFavoriteHolidays(){}

    public void findFavoriteHoliday(){}

    public void printFavoriteHolidays(){}

    private void refreshFavoriteHolidays(){}

    private void sortFavoriteHolidays(){}



}
