package com.vuson.abc.april;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Data
class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //gettersm setters, toString
}


public class NowJava8 {

//    public static void main(String[] args) {
//
//        List<Person> persons = Arrays.asList(
//                new Person("mkyong", 30),
//                new Person("jack", 20),
//                new Person("lawrence", 40)
//        );
//
//        Person result1 = persons.stream()                        // Convert to steam
//                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
//                .findAny()                                      // If 'findAny' then return found
//                .orElse(null);                                  // If not found, return null
//
//        System.out.println(result1);
//
//        Person result2 = persons.stream()
//                .filter(x -> "ahmook".equals(x.getName()))
//                .findAny()
//                .orElse(null);
//
//        System.out.println(result2);
//
//    }


    public static void main(String[] args) {

        List<String> lines = Arrays.asList("son", "node", "tuan");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"tuan".equals(line))     // we dont like tuan
                .filter(line -> !"son".equals(line))     // we dont like son
                .collect(Collectors.toList());              // collect the output and convert streams to a List
        result.forEach(System.out::println);                //output : spring, node

    }

}

