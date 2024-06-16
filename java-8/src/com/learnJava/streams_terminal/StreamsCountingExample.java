package com.learnJava.streams_terminal;

import com.learnJava.data.StudentDataBase;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsCountingExample {

    public static long count(){
       return  StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.counting());
    }

    public static long countCharArray(char[] arr){
        return IntStream.range(0, arr.length).filter(i -> arr[i] == 'S').count();
    }

    public static void main(String[] args) {

        System.out.println(count());
        System.out.println(countCharArray("SSPPSPS".toCharArray()));
        System.out.println(countCharArray("PPSPSP".toCharArray()));
    }
}
