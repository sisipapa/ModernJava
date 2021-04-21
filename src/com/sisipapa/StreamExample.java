package com.sisipapa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExample {

    /**
     * List를 정렬할 때는 Collection.sort()를 사용해야하고,
     * 배열을 정렬할 때는 Arrays.sort()를 사용해야 한다.
     * 이렇게 데이터 소스마다 다른 방식으로 다루어야하는 문제점을 해결해주는 것이 Stream 이다.
     */
    public static void streamTest1(){
        // Arrays.asList(String[] => List<String>)
        String[] strArr = {"aaa", "bbb", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Stream<String> strStream1 = strList.stream();       // List => Stream
        Stream<String> strStream2 = Arrays.stream(strArr);  // Arrays => Stream

        strStream1.sorted().forEach(System.out::println);
        strStream2.sorted().forEach(System.out::println);
    }

    /**
     * 스트림은 최종 연산이 수행되기 전까지 중간 연산이 수행되지 않는다.
     * 중간 연산을 호출하는 것은 단지 어떤 작업이 수행되어야하는지를 지정해주는 것일 뿐이다.
     * 요소의 타입이 T인 스트림은 Stream이지만,
     * 오토박싱/언박싱의 비효율을 줄이기 위해 데이터 소스의 요소를 기본형으로 다루는 InsStream, LongStream, DoubleStream이 제공된다.
     */
    public static void streamTest2(){
        System.out.println("###range");
        IntStream.range(0, 10).forEach(num -> System.out.print(" " + num));
        System.out.println("");
        System.out.println("###rangeClosed");
        IntStream.rangeClosed(0, 10).forEach(num -> System.out.print(" " + num));
    }

    public static void main(String[] args){
        streamTest1();
        streamTest2();
    }

}
