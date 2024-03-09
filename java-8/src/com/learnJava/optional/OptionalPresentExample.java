package com.learnJava.optional;

import java.util.Optional;

public class OptionalPresentExample {

    public static void main(String[] args) {

        Optional<String> stringOptional = Optional.ofNullable("Hello Optional");

        System.out.println(stringOptional.isPresent());

        stringOptional.ifPresent((s -> System.out.println("stringOptional value is : " + s)));

        Optional<String> optionalString = Optional.ofNullable(null);
        optionalString.ifPresentOrElse((s) -> System.out.println("OptionalString is:" + optionalString), ()->
                System.out.println("OptionalString is: null"));
    }
}
