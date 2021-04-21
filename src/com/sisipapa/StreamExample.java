package com.sisipapa;

import java.util.Arrays;
import java.util.List;
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

    public static void main(String[] args){
        streamTest1();
    }

}
