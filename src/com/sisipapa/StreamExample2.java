package com.sisipapa;

import java.util.Arrays;
import java.util.List;

public class StreamExample2 {

    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /**
     * 반복문/제어문을 활용
     */
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

    /**
     * Stream lamda1
     */
    public static void method2(){
        System.out.println("\n==================================");
        System.out.println("Stream filter와 map을 활용한 결과 lamda1 : " +
                NUMBERS.stream()
                        .filter(number -> number > 3)
                        .filter(number -> number < 9)
                        .map(number -> number * 2)
                        .filter(number -> number > 10)
                        .findFirst()
        );
    }

    /**
     * Stream lamda2
     */
    public static void method3(){
        System.out.println("\n==================================");
        System.out.println("Stream filter와 map을 활용한 결과 lamda2 : " +
                NUMBERS.stream()
                        .filter(number -> {
                            return number > 3;
                        })
                        .filter(number -> {
                            return number < 9;
                        })
                        .map(number -> {
                            return number * 2;
                        })
                        .filter(number -> {
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
