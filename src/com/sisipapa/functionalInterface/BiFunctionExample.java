package com.sisipapa.functionalInterface;

import java.util.function.BiFunction;

public class BiFunctionExample {
    // BiFunction<T, U, R>
    // 역할: 두 개의 입력값을 받아 변환하여 반환.
    // 예시: 가격 계산 (상품 가격 + 세금)
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> biFunction = (price, tax) -> price + (price * tax);

        double price = 100.0;
        double taxRate = 0.1; // 10%
        double totalPrice = biFunction.apply(price, taxRate);

        System.out.println("총 가격: " + totalPrice);
    }
}
