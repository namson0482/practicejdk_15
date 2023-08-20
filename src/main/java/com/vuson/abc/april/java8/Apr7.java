package com.vuson.abc.april.java8;

import com.vuson.abc.april.Person;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;


@Slf4j
public class Apr7 {


    private static void testArray() {
        List<String> list = Arrays.asList("son", "hai");
        String[] items = list.stream().toArray(String[]::new);
        List result = list.stream().filter(value -> !value.equals("son")).collect(Collectors.toList());
    }

    private static void testHashMap() {
        Map<String, Set> hashMap = new HashMap<>();
        hashMap.computeIfAbsent("1", v -> new HashSet<>()).add("2");
    }

    public static void testOptional() {
        Person person = getPerson();
        Optional<Person> optional = Optional.ofNullable(person);
        if (optional.isPresent()) {
            System.out.println(optional.get().name);
        }
        // opt.ifPresent(s -> System.out.println(s.name));
    }

    private static Person getPerson() {
        Person person = new Person();
        person.name = "gpcoder.com";
        return null;
    }

    static List<String> names = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

    public static String getRandomName() {
        log.info("getRandomName() method - start");

        Random random = new Random();
        int index = random.nextInt(5);

        log.info("getRandomName() method - end");
        return names.get(index);
    }

    public static void main(String[] args) {

//        String value = Optional.ofNullable("son").orElse(getRandomName());
//        log.info(value);

//        List<String> lines = Arrays.asList("son", "node", "tuan");
//
//        List<String> result = lines.stream()                // convert list to stream
//                .filter(line -> !"tuan".equals(line))     // we dont like tuan
//                .filter(line -> !"son".equals(line))     // we dont like son
//                .collect(Collectors.toList());              // collect the output and convert streams to a List
//        result.forEach(System.out::println);                //output : spring, node=
//        testOptional();


//        int[] example1 = list.stream().mapToInt(i->i).toArray();
// OR
//        int[] example2 = list.stream().mapToInt(Integer::intValue).toArray();

//        int[] input = new int[]{1,2,3,4};
//        List<Integer> output = Arrays.stream(input).boxed().collect(Collectors.toList());

//        int[] input = new int[]{1,2,3,4};
//        List<Integer> output = IntStream.of(input).boxed().collect(Collectors.toList());

        testMapAndFlatMap_1();
    }

    private static void testConversionArray() {
        String []arr = {"A", "", "B"};
        String []values  =  Arrays.stream(arr).filter(v->v.length()>0)
                .map(v->v.charAt(0) + "")
                .toArray(String[]::new);
    }

    /**
     * map and flatMap
     */

    static void testMapAndFlatMap() {
        Optional<String> s = Optional.of("test");
        Optional<Integer> r = s.map(String::length);
        if (r.isPresent()) {
            System.out.println(r.get());
        }
    }

    static void testMapAndFlatMap_1() {
        Optional<Optional<String>> optionalValue = Optional.of(Optional.of("test"));
        Optional<Integer> normalMap = optionalValue.map(v -> v.get()).map(String::length);
        Optional<Integer> flatMap = optionalValue.flatMap(q -> q).map(String::length);
        if (flatMap.isPresent()) {
            System.out.println(flatMap.get());
        }
        if (normalMap.isPresent())
            log.info(normalMap.get().toString());
    }

    static void testMapAndFlatMap_2() {
//        List<String> list = Stream.of("1", "2").map(String::toUpperCase).collect(Collectors.toList());
        List<List<String>> list = Arrays.asList(List.of("a"), List.of("b"));
        System.out.println(list);
        System.out.println(list.stream().flatMap(Collection::stream).collect(Collectors.toList()));

    }

    static void testMapAndFlatMap_3() {

        assertEquals(Optional.of(Optional.of("STRING")),
                Optional.of("string").map(s -> Optional.of("STRING")));
        assertEquals(Optional.of("STRING"),
                Optional.of("string").flatMap(s -> Optional.of("STRING")));

        Optional<String> s = Optional.of("test");
        assertEquals(Optional.of("TEST"), s.map(String::toUpperCase));
        log.info("end");
    }


    static void testFlatMapAndMap_1() {

        Optional<String> optionalValue = Optional.ofNullable("son");
        Optional<Integer> optionalInteger = optionalValue.map(String::length);

        Optional<Optional<String>> optionNested = Optional.of(optionalValue);
        Optional<Integer> optionInt_1 = optionNested.flatMap(q -> q).map(String::length);

    }


    private static List<String> getList() {
        return null;
    }

    private static Optional<List<String>> getList2() {
        return Optional.ofNullable(new ArrayList<>());
    }

    private static List run() {
        log.info("Alo");
        return new ArrayList();
    }

    private static void testOrElseGet() {
        // Pre java 8
        List<String> list = getList();
        List<String> listOpt = list != null ? list : new ArrayList<>();

        // Java 8
        List<String> listOpt2 = getList2().orElse(run());
        List<String> listOpt3 = getList2().orElseGet(() -> run());
    }


    private static final String MOST_EVIL_PRICE_PLAN_ID = "price-plan-0";
    private static final String RENEWABLES_PRICE_PLAN_ID = "price-plan-1";
    private static final String STANDARD_PRICE_PLAN_ID = "price-plan-2";
    public List<PricePlan> pricePlans() {
        final List<PricePlan> pricePlans = new ArrayList<>();
        pricePlans.add(new PricePlan(MOST_EVIL_PRICE_PLAN_ID, "Dr Evil's Dark Energy", BigDecimal.TEN, emptyList()));
        pricePlans.add(new PricePlan(RENEWABLES_PRICE_PLAN_ID, "The Green Eco", BigDecimal.valueOf(2), emptyList()));
        pricePlans.add(new PricePlan(STANDARD_PRICE_PLAN_ID, "Power for Everyone", BigDecimal.ONE, emptyList()));
        return pricePlans;
    }

    public Map<String, List<ElectricityReading>> perMeterElectricityReadings() {
        final Map<String, List<ElectricityReading>> readings = new HashMap<>();
        final ElectricityReadingsGenerator electricityReadingsGenerator = new ElectricityReadingsGenerator();
        smartMeterToPricePlanAccounts()
                .keySet()
                .forEach(smartMeterId -> readings.put(smartMeterId, electricityReadingsGenerator.generate(2)));
        return readings;
    }

    public Map<String, String> smartMeterToPricePlanAccounts() {
        final Map<String, String> smartMeterToPricePlanAccounts = new HashMap<>();
        smartMeterToPricePlanAccounts.put("smart-meter-0", MOST_EVIL_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-1", RENEWABLES_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-2", MOST_EVIL_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-3", STANDARD_PRICE_PLAN_ID);
        smartMeterToPricePlanAccounts.put("smart-meter-4", RENEWABLES_PRICE_PLAN_ID);
        return smartMeterToPricePlanAccounts;
    }

}

