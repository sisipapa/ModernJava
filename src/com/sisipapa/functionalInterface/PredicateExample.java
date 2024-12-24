package com.sisipapa.functionalInterface;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        // Predicate<T>
        // 역할: 입력값을 받아 boolean 값을 반환.
        // 예시: 사용자 권한 검증 로직
        Predicate<String> hasRole = role -> "ADMIN".equalsIgnoreCase(role);

        String userRole = "OPERATOR";
        if(hasRole.test(userRole)){
            System.out.println("ADMIN 입니다.");
        }else{
            System.out.println("ADMIN이 아닙니다.");
        }
    }
}
