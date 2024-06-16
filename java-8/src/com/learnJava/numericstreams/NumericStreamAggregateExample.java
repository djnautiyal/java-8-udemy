package com.learnJava.numericstreams;

import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {


        int sum = IntStream.rangeClosed(1,50).sum();
        System.out.println("Sum : "+ sum);

        OptionalInt max = IntStream.rangeClosed(1,50).max();
        System.out.println(max.isPresent());
        System.out.println(max.isPresent() ? max.getAsInt() : 0);

        OptionalLong min = LongStream.rangeClosed(1,50).min();
        System.out.println(min.getAsLong());

        OptionalDouble avg = IntStream.rangeClosed(1,50).average();
        System.out.println(avg.getAsDouble());

        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println("arr max: " + Arrays.stream(arr).max().getAsInt());
        System.out.println("arr min: " + Arrays.stream(arr).min().getAsInt());
        System.out.println("arr sum: " + Arrays.stream(arr).sum());
    }
}
