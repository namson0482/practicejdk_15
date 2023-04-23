package com.vuson.abc.april.java8;

import avro.shaded.com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.IntStream;

@Slf4j
public class Apr20 {


    static class Point {
        double x;
        double y;
        Point(double x, double y) {
            this.x= x;
            this.y = y;
        }
    }

    private static void testOptional() {
        Optional<Optional<String>> optionalNested = Optional.of(Optional.of("vuson"));
        Optional<Integer> optionInt = optionalNested.flatMap(q->q).map(String::length);

        int []arr = {1, 4, 2, 8};
        List<String> listOne = Arrays.asList("son", "nguyen", "vu");

        String resultString = listOne.stream()
                .reduce("", (partialString, element) -> partialString + element.charAt(0));
        log.info(resultString);


        int resultInt = IntStream.of(arr).boxed().reduce(0, (a, b) -> a + b);
        log.info(resultInt + "");

        List<Integer> listInteger = Arrays.asList(1, 5, 8, 9);


        String []arrString = listOne.stream().toArray(String[]::new);
        int []arrInt = listInteger.stream().mapToInt(Integer::intValue).toArray();

        Arrays.stream(arrString).forEach(v -> System.out.print(v + " "));
        Arrays.stream(arrInt).forEach(v -> System.out.print(v + " "));

    }

    private static double generate() {
        return Math.random() * ( 100 - 10 );
    }

    private static List<Point> generatePoint() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(generate(), generate()));
        points.add(new Point(generate(), generate()));
        points.add(new Point(generate(), generate()));
        return points;
    }


    private static void testMap() {

        Map<String, List<Point>> mapPoints = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        TreeSet<Integer> treeSet = new TreeSet((o1, o2) -> (int)o1 > (int)o2 ? 1: -1);

        map.put("1", "number1");
        map.put("2", "number2");
        map.put("3", "number3");
        map.put("4", "number4");
        map.put("5", "number5");
        map.put("6", "number6");

        treeSet.add(8); treeSet.add(7);
        treeSet.add(5); treeSet.add(1); treeSet.add(1); treeSet.add(2);

        map.keySet().forEach(keyId -> mapPoints.put(keyId, generatePoint()));


        mapPoints.entrySet().forEach(v -> {
            List<Point> lst = v.getValue();
            String stemp = "";
            for(Point item: lst) {
                stemp += "x=" + String.format( "%.2f", item.x )  + " y=" + String.format( "%.2f", item.y ) + "\n";
            }
            System.out.println(v.getKey());
            System.out.println(stemp);
        });

//        for(Map.Entry<String, List<Point>> entry: mapPoints.entrySet()) {
//            List<Point> listTemp = entry
//        }

    }

    private static void sortPrimitive() {
        int[] arr = {4, 2, 3, 1, 5};
        Ints.asList(arr).sort(Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));

        String string = "Item1 10 Item2 25 Item3 30 Item4 45";

        Integer sum = Arrays.stream(string.split(" "))
                .filter((s) -> s.matches("\\d+"))
                .mapToInt(Integer::valueOf)
                .sum();
        log.info("{}", sum);

    }


    public static void main(String[] args) {
//        testOptional();
        testMap();
        sortPrimitive();
    }
}
