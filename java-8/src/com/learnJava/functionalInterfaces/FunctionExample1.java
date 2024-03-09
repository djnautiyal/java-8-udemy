package com.learnJava.functionalInterfaces;

public class FunctionExample1 {

    public static String appendDefault(String input){

        return FunctionExample.addSomeString.apply(input);
    }

    public static void main(String[] args) {
        System.out.println("Initial string length of the string 'hello' is:" + FunctionExample.strLength.apply("hello"));
        System.out.println("String being added: " + FunctionExample.addSomeString.apply(""));

        int resultingLength = FunctionExample.addSomeString.andThen(FunctionExample.strLength).apply("hello");
        System.out.println("Resulting length of the string 'hello' is: " + resultingLength);
    }

}
