package com.vuson.abc.april.java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class MondaySunday {

    LocalDate getMonday() {
        LocalDate localDate = LocalDate.now();
        while(localDate.getDayOfWeek() != DayOfWeek.MONDAY) {
            localDate = localDate.minusDays(1);
        }
        return localDate;
    }

    LocalDate getSunday() {
        LocalDate localDate = LocalDate.now();
        while(localDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
            localDate = localDate.plusDays(1);
        }
        return localDate;
    }

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Go backward to get Monday
        LocalDate monday = today;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }

        Instant instantMonday = monday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        // Go forward to get Sunday
        LocalDate sunday = today;
        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            sunday = sunday.plusDays(1);
        }

        Instant instantSunday = sunday.atStartOfDay(ZoneId.systemDefault()).toInstant();

        System.out.println("Today: " + today);
        System.out.println("Monday of the Week: " + instantMonday);
        System.out.println("Sunday of the Week: " + instantSunday);
    }
}
