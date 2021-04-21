package com.sisipapa;

import java.util.Arrays;
import java.util.List;

public class StreamExample2 {

    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void method1(){
        Integer result = null;
        for (final Integer number : NUMBERS) {
            if (number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("\n==================================");
        System.out.println("반복문 제어문의 결과: " + result);
    }

    public static void method2(){
        System.out.println("\n==================================");
        System.out.println("Stream filter와 map을 활용한 결과: " +
                NUMBERS.stream()
                        .filter(number -> number > 3)
                        .filter(number -> number < 9)
                        .map(number -> number * 2)
                        .filter(number -> number > 10)
                        .findFirst()
        );
    }

    public static void method3(){
        System.out.println("\n==================================");
        System.out.println("Stream filter와 map을 활용한 결과 (with logging): " +
                NUMBERS.stream()
                        .filter(number -> {
                            System.out.println("number > 3");
                            return number > 3;
                        })
                        .filter(number -> {
                            System.out.println("number < 9");
                            return number < 9;
                        })
                        .map(number -> {
                            System.out.println("number * 2");
                            return number * 2;
                        })
                        .filter(number -> {
                            System.out.println("number > 10");
                            return number > 10;
                        })
                        .findFirst()
        );
        System.out.println("\n==================================");
    }

    public static void main(String[] args) {
        method1();
        method2();
        method3();
    }
}
