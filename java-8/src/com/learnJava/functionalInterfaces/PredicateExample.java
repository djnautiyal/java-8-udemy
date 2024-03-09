package com.learnJava.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> p = (i) -> {return  i%2 ==0;};

    static Predicate<Integer> p1 = (i) -> i%2 ==0;

    static Predicate<Integer> p2 = (i) -> i%5 ==0;


    public static void predicateAnd(){

        System.out.println("Result in predicateAnd for 10: " + p1.and(p2).test(10));
        System.out.println("Result in predicateAnd for 9: " + p1.and(p2).test(9));
    }

    public static void predicateOr(){

        System.out.println("Result in predicateOr for 10: " + p1.or(p2).test(10));
        System.out.println("Result in predicateOr for 9: " + p1.or(p2).test(9));
        System.out.println("Result in predicateOr for 15: " + p1.or(p2).test(15));
    }

    public static void predicateNegate(){

        System.out.println("Result in predicateNegate for 4: " + p1.and(p2).negate().test(4)); //equivalent to reversing the result
    }


    public static void main(String[] args) {

        System.out.println("Result is p for 2: " + p.test(2));

        System.out.println("Result is p1 for 3: " + p1.test(3));

        predicateAnd();

        predicateOr();

        predicateNegate();

    }


}
