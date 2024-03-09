package com.learnJava.streams;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsOfGenerateIterateExample {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("adam","dan","jenny","dave");
        stringStream.forEach(System.out::println);

        List<Integer> integerList  = Stream.iterate(1, x->x*2)
                .limit(10)
                .collect(toList());

        System.out.println("iterate : " + integerList);


        Supplier<Integer> supplier = new Random()::nextInt;

        List<Integer> integerList1  = Stream.generate(supplier)
                .limit(10)
                .collect(toList());
        System.out.println("generate : " + integerList1);

        System.out.println("Hackerrank question");
        int sum = Stream.iterate(new int[]{0,1}, x -> new int[]{x[1], x[0]+x[1]})
                .limit(7)
                .map(x -> x[0])
                .collect(toList())
                .stream()
                .distinct()
                .filter(i -> i%2==0)
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);
    }
}
