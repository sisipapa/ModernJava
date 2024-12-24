package com.sisipapa;

import java.util.function.Consumer;

public class ConsumerExample {
    // Consumer<T>
    // 역할: 입력값을 받아 소비(출력, 저장)하고 반환값 없음.
    // 예시: 로그 기록 로직
    public static void main(String[] args) {
        Consumer<String> logMessage = (message) -> System.out.println(message + "입니다.");
        logMessage.accept("테스트");
    }
}
