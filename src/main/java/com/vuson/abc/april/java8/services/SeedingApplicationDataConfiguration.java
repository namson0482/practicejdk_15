package com.vuson.abc.april.java8.services;

import com.vuson.abc.april.java8.ElectricityReading;
import com.vuson.abc.april.java8.ElectricityReadingsGenerator;
import com.vuson.abc.april.java8.PricePlan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class SeedingApplicationDataConfiguration {

    private static final String MOST_EVIL_PRICE_PLAN_ID = "price-plan-0";
    private static final String RENEWABLES_PRICE_PLAN_ID = "price-plan-1";
    private static final String STANDARD_PRICE_PLAN_ID = "price-plan-2";

    public static List<PricePlan> pricePlans() {
        final List<PricePlan> pricePlans = new ArrayList<>();
        pricePlans.add(new PricePlan(MOST_EVIL_PRICE_PLAN_ID, "Dr Evil's Dark Energy", BigDecimal.TEN, emptyList()));
        pricePlans.add(new PricePlan(RENEWABLES_PRICE_PLAN_ID, "The Green Eco", BigDecimal.valueOf(2), emptyList()));
        pricePlans.add(new PricePlan(STANDARD_PRICE_PLAN_ID, "Power for Everyone", BigDecimal.ONE, emptyList()));
        return pricePlans;
    }

    public static Map<String, List<ElectricityReading>> perMeterElectricityReadings() {
        final Map<String, List<ElectricityReading>> readings = new HashMap<>();
        final ElectricityReadingsGenerator electricityReadingsGenerator = new ElectricityReadingsGenerator();
        smartMeterToPricePlanAccounts()
                .keySet()
                .forEach(smartMeterId -> readings.put(smartMeterId, electricityReadingsGenerator.generate(20)));
        return readings;
    }

    public static Map<String, String> smartMeterToPricePlanAccounts() {
        final Map<String, String> smartMeterToPricePlanAccounts = new HashMap<>();
        smartMeterToPricePlanAccounts.put("smart-meter-0", MOST_EVIL_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-1", RENEWABLES_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-2", MOST_EVIL_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-3", STANDARD_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-4", RENEWABLES_PRICE_PLAN_ID);
        return smartMeterToPricePlanAccounts;
    }

//    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        return objectMapper;
//    }

}
