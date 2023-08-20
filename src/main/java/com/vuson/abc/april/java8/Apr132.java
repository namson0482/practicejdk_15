package com.vuson.abc.april.java8;

import com.vuson.abc.april.java8.services.MeterReadingService;
import com.vuson.abc.april.java8.services.PricePlanService;
import com.vuson.abc.april.java8.services.SeedingApplicationDataConfiguration;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Apr132 {

    final MeterReadingService meterReadingService;

    final PricePlanService pricePlanService;
    public Apr132() {
        Map<String, List<ElectricityReading>> meterAssociatedReadings = SeedingApplicationDataConfiguration.perMeterElectricityReadings();
        meterReadingService = new MeterReadingService(meterAssociatedReadings);
        List<PricePlan> pricePlans = SeedingApplicationDataConfiguration.pricePlans();
        pricePlanService = new PricePlanService(pricePlans, meterReadingService);
        Optional<Map<String, BigDecimal>> optional = pricePlanService.getConsumptionCurrentWeek("smart-meter-0");
        if(optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    public static void test() {
        List<List<Integer>> listNested = Arrays.asList(
                Arrays.asList(1, 2, 4),
                Arrays.asList(8, 9, 10),
                Arrays.asList(88, 99, 110),
                Arrays.asList(82, 92, 101),
                Arrays.asList(18, 12, 11));

        int []arrayNumbers = {1, 5, 10, 3, 7, 9};
        List<Integer> listNumbers = Arrays.stream(arrayNumbers).boxed().collect(Collectors.toList());

        int []arr = listNumbers.stream().mapToInt(a->a).toArray();
        List<Integer> listRes = listNested.stream().flatMap(a->a.stream()).collect(Collectors.toList());

        Collections.sort(listRes, (a, b) -> a > b ? 1: -1);
        listRes.forEach(v -> System.out.print(v +" "));
    }

    public static void main(String[] args) {
//        new Apr132();
        test();
    }
}
