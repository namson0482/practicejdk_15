package com.vuson.abc.april.java8.services;

import com.vuson.abc.april.java8.ElectricityReading;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MeterReadingService {
    private final Map<String, List<ElectricityReading>> meterAssociatedReadings;

    public MeterReadingService(Map<String, List<ElectricityReading>> meterAssociatedReadings) {
        this.meterAssociatedReadings = meterAssociatedReadings;
    }

    public Optional<List<ElectricityReading>> getReadingsCurrentWeek(String smartMeterId) {
        List<ElectricityReading> listTemp = meterAssociatedReadings.get(smartMeterId);
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
        listTemp = listTemp.stream().filter(x -> {
            boolean after = x.getTime().isAfter(instantMonday);
            boolean before = x.getTime().isBefore(instantSunday);
            return after & before;
        }).collect(Collectors.toList());


        return Optional.ofNullable(listTemp);
    }

    public Optional<List<ElectricityReading>> getReadings(String smartMeterId) {
        return Optional.ofNullable(meterAssociatedReadings.get(smartMeterId));
    }

    public void storeReadings(String smartMeterId, List<ElectricityReading> electricityReadings) {
        if (!meterAssociatedReadings.containsKey(smartMeterId)) {
            meterAssociatedReadings.put(smartMeterId, new ArrayList<>());
        }
        meterAssociatedReadings.get(smartMeterId).addAll(electricityReadings);
    }
}
