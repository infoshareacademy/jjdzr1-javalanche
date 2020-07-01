package com.infoshareacademy.api;

import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

public class FavoriteHolidays {

    private static List<Holidays> favoriteHolidays = HolidaysJsonData.readDataFromJsonFile().getServerResponse().getHolidays();
    private static Scanner scanner = new Scanner(System.in);

    public void addFavoriteHolidays(){}

    public void removeFavoriteHolidays(){}

    public void printFavoriteHolidays(){}

    private void refreshFavoriteHolidays(){}

    private void sortFavoriteHolidays(){}



}
