package com.sisipapa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample3 {

    /**
     * Optional 생성
     * Optional.of를 사용해서 String의 래퍼클래스로 생성
     * Optional.get을 사용해서 Optional객체 내부의 String객체에 접근
     */
    public static void basic1(){
        String value = "This is not null String";
        Optional<String> optionalStr = Optional.of(value);
        System.out.println("basic1 result : " + optionalStr.get());
    }

    /**
     * Optional.ofNullable
     */
    public static void basic2(){
        String nullValue = null;
        Optional<String> nullOptionalStr = Optional.ofNullable(nullValue);
        try{
            System.out.println(nullOptionalStr.get());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Optional.empty
     */
    public static void basic3(){
        Optional<String> nullOptionalStr = Optional.empty();
        try{
            System.out.println(nullOptionalStr.get());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * null check를 isPresent, ifPresent 활용
     */
    public static void basic4(){
        Optional<String> optionalStr = Optional.of("This is not null String");
        Optional<String> nullOptionalStr = Optional.ofNullable(null);

        if (optionalStr.isPresent()) {
            System.out.println("optionalStr: " + optionalStr.get());
        }
        optionalStr.ifPresent(str -> System.out.println("optionalStr[ifPresent] : " + optionalStr.get()));

        if (nullOptionalStr.isPresent()) {
            System.out.println("nullOptionalStr[isPresent]: " + nullOptionalStr.get());
        }
        nullOptionalStr.ifPresent(str -> System.out.println("nullOptionalStr[ifPresent] : " + nullOptionalStr.get()));
    }

    /**
     * orElse
     */
    public static void basic5(){
        Optional<String> optionalStr = Optional.of("This is not null String");
        Optional<String> nullOptionalStr = Optional.ofNullable(null);

        String optionalStr2 = optionalStr.orElse("optionalStr 대체 String 입니다.");
        String nullOptionalStr2 = nullOptionalStr.orElse("nullOptionalStr 대체 String 입니다.");

        System.out.println("optionalStr2 : " + optionalStr2);
        System.out.println("nullOptionalStr2 : " + nullOptionalStr2);
    }

    /**
     * orElseGet
     */
    public static void basic6(){
        Optional<String> optionalStr = Optional.of("This is not null String");
        Optional<String> nullOptionalStr = Optional.ofNullable(null);

        String optionalStr2 = optionalStr.orElseGet(() -> "[orElseGet] This is not null String");
        String nullOptionalStr2 = nullOptionalStr.orElseGet(() -> "[orElseGet] This is null String");

        System.out.println("optionalStr2 : " + optionalStr2);// This is not null String
        System.out.println("nullOptionalStr2 : " + nullOptionalStr2); // [orElseGet] This is null String
    }

    /**
     * orELseThrow
     */
    public static void basic7(){
        Optional<String> optionalStr = Optional.of("This is not null String");
        Optional<String> nullOptionalStr = Optional.ofNullable(null);

        try{
            String optionalStr2 = optionalStr.orElseThrow(() -> {throw new NullPointerException();});
            System.out.println("optionalStr2 : " + optionalStr2);
        }catch(NullPointerException e){
            System.err.println("NullPointerException");
        }

        try{
            String nullOptionalStr2 = nullOptionalStr.orElseThrow(() -> {throw new NullPointerException();});
            System.out.println("nullOptionalStr2 : " + nullOptionalStr2);
        }catch(NullPointerException e){
            System.err.println("NullPointerException");
        }
    }


    public static void main(String[] args) {
//        basic1();
//        basic2();
//        basic3();
//        basic4();
//        basic5();
//        basic6();
        basic7();
    }
}
