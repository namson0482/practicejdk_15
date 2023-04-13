package com.vuson.abc.april.java8;

import com.vuson.abc.april.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


@Slf4j
public class Apr7 {


    private static void testArray() {
        List<String> list = Arrays.asList(new String[]{"son", "hai"});
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

    static List<String> names = new ArrayList<>(Arrays.asList(new String[]{"1", "2", "3", "4", "5"}));

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

        testMapAndFlatMap_1();
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
        List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
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

}

