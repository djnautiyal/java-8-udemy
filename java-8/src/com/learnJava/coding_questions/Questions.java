package com.learnJava.coding_questions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions {
    public static void main(String[] args) {
        int[] arr = {10,15,8,49,25,98,98,32,15};
        System.out.println("arr: "+ Arrays.toString(arr));

        System.out.println("\n1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?");
        Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .forEach(x -> System.out.print(x + " \t"));


        System.out.println("\n2.Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
        Arrays.stream(arr)
                .mapToObj(x -> String.valueOf(x))
                .filter(s -> s.startsWith("1"))
                .forEach(x -> System.out.print(x + " \t"));


        System.out.println("\n3.How to find duplicate elements in a given integers list in java using Stream functions?");
        var set = new HashSet<Integer>();
        Arrays.stream(arr)
                .filter(x -> !set.add(x))
                .forEach(x -> System.out.print(x + " \t"));

        System.out.println("\n4.Given the list of integers, find the first element of the list using Stream functions?");
        Arrays.stream(arr)
                .findFirst()
                .ifPresent(x -> System.out.println(x));

        System.out.println("\n5.Given a list of integers, find the total number of elements present in the list using Stream functions?");
        System.out.println(Arrays.stream(arr).count());

        System.out.println("\n6.Given a list of integers, find the maximum value element present in it using Stream functions?");
        System.out.println(Arrays.stream(arr).max().getAsInt());


        System.out.println("\n7. Given a String, find the first non-repeated character in it using Stream functions?");
        String str = "Java articles are Awesome";
        var charSet = new HashSet<Character>();
        str.chars()
                .mapToObj(x -> Character.toLowerCase((char)x))
                .filter(x -> charSet.add((char) x))
                .findFirst().ifPresent(x -> System.out.println((char) x));

        str.chars()
                .mapToObj(x -> Character.toLowerCase((char) x))
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(e -> e.getValue()==1L)
                .map(e -> e.getKey())
                .findFirst().ifPresent(System.out::println);

        System.out.println("\n8.Given a String, find the first repeated character in it using Stream functions?");
        var cSet = new HashSet<Character>();
        str.chars()
                .mapToObj(x -> Character.toLowerCase((char)x))
                .filter(x -> cSet.add((char)x))
                .findFirst().ifPresent(x -> System.out.println((char) x));

        System.out.println("\n9.Given a list of integers, sort all the values present in it using Stream functions?");
        System.out.println(Arrays.toString(Arrays.stream(arr)
                .sorted().toArray()));

        System.out.println("\n10.Given a list of integers, sort all the values present in it in descending order using Stream functions?");
        System.out.println(Arrays.toString(Arrays.stream(arr).boxed()
                .sorted((x, y) -> y-x)
                .toArray()));

        System.out.println("\n11.Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.");
        Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue()>=2L)
                .findFirst()
                .ifPresentOrElse(x -> System.out.println(true), () -> System.out.println(false));

        System.out.println("\n12.How will you get the current date and time using Java 8 Date and Time API?");
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());

        System.out.println("\n13. Write a Java 8 program to concatenate two Streams?");
        List<String> A = Arrays.asList("Java", "8");
        List<String> B = Arrays.asList("explained", "through", "programs");
        Stream.concat(A.stream(), B.stream()).forEach(x -> System.out.print(x + " \t"));

        System.out.println("\n14. Java 8 program to perform cube on list elements and filter numbers greater than 50.");
        Arrays.asList(4,5,6,7,1,2,3).stream()
                .map(x -> x*x*x)
                .filter(x -> x >= 50)
                .forEach(x -> System.out.print(x + " \t"));

        System.out.println("\n15.Write a Java 8 program to sort an array and then convert the sorted array into Stream?");
        Arrays.asList(4,5,6,7,1,2,3).stream()
                .sorted((x,y) -> y-x)
                .forEach(x -> System.out.print(x + " \t"));

        System.out.println("\n16.How to use map to convert object into Uppercase in Java 8?");
        str.chars()
                .mapToObj(c -> Character.toUpperCase((char)c))
                .forEach(x -> System.out.print(x));

        System.out.println("\n17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?");
//        Arrays.asList(1,2,3,4,51,6,7)

        System.out.println("\n18. How to count each element/word from the String ArrayList in Java8?");
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        names.stream()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet().stream()
                .forEach(e -> System.out.println("[" + e.getKey() + ":" + e.getValue() + "]\t"));

        System.out.println("\n19. How to find only duplicate elements with its count from the String ArrayList in Java8?");
        names.stream()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue()>1)
                .forEach(e -> System.out.println("[" + e.getKey() + ":" + e.getValue() + "]\t"));

        System.out.println("\n20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?");
        List<Integer> list = new ArrayList<>();
        Optional.ofNullable(list)
                .orElseGet(() -> Collections.emptyList())
                .stream().filter(Objects::nonNull)
                .forEach(System.out::println);

        System.out.println("\n21. Partition the list into two groups: one containing even numbers and the other containing odd numbers. Additionally, provide the sum of each group.");
        Map<Boolean, Integer> partitionedAndSummed = Arrays.stream(arr).boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0,
                        Collectors.summingInt(Integer::intValue)));

        System.out.println("Sum of even numbers: " + partitionedAndSummed.get(true));
        System.out.println("Sum of odd numbers: " + partitionedAndSummed.get(false));


    }
}