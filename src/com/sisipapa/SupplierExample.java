package com.sisipapa;

import java.util.UUID;
import java.util.function.Supplier;

public class SupplierExample {
    // Supplier<T>
    // 역할: 입력값 없이 값을 생성하여 반환.
    // 예시: 인증 토큰 생성
    public static void main(String[] args) {
        Supplier<String> generateAuth = () -> UUID.randomUUID().toString();
        System.out.println(generateAuth.get());
    }
}
