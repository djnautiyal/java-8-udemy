package com.learnJava.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaVariable1 {


    public static void main(String[] args) {

        int i=0; //Repeated varibale name not allowed
//        Consumer<Integer> c2 = (i) -> {
//            System.out.println(i);
//        };
        Consumer<Integer> c1 = (a) -> {
            //int i=0;
            System.out.println(i);
        };

        Consumer<Integer> c2 = (a) -> {
            Integer x = i;
            x++;
            System.out.println(x);
        };

        c1.accept(1);
        c2.accept(4);

    }
}
