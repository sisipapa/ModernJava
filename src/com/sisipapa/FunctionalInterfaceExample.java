package com.sisipapa;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

    public static void notLambda(){
        System.out.println(new MyFuntionalInterface() {
            @Override
            public int plusOne(int i) {
                return i + 1;
            }
        }.plusOne(3));
    }

    public static void lambda(){
        MyFuntionalInterface myFunction = (int i) -> i+1;
        System.out.println(myFunction.plusOne(3));
    }

    static int index = 1;
    public static void main(String[] args) {
//        notLambda();
//        lambda();

//        Runnable runnable = () -> System.out.println("This is run method");
//        runnable.run();

//        Supplier<Integer> getFirstIndex = () -> 0;
//        Integer firstIndex = getFirstIndex.get();
//        System.out.println(firstIndex);

//        Consumer<String> getGender = paramGender -> System.out.println("Gender : " + paramGender);
//        getGender.accept("man");
//

//        Consumer<String> str1 = msg -> System.out.println(msg + " 첫번째 실행");
//        Consumer<String> str2 = msg -> System.out.println(msg + " 두번째 실행");
//        str1.andThen(str2).accept("sisipapa");

//        Function<Integer, Integer> plusOne = (value) -> value + 1;
//        Integer result = plusOne.apply(5);
//        System.out.println(result);

//        Function<Integer, Integer> minusOne = (value) -> value - 1;
//        Function<Integer, Integer> plusOne = (value) -> value + 1;
//
//        Function<Integer, Integer> composeMethod = minusOne.compose(plusOne);
//        Integer result = composeMethod.apply(5);
//        System.out.println(result);

        Predicate<Integer> isOddNumber = value -> value % 2 != 0;
        System.out.println("Is the entered number odd? -> " + isOddNumber.test(3));
    }
}
