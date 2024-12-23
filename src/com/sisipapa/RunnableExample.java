package com.sisipapa;

public class RunnableExample {

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Runnable task executed!");
        task.run();
    }
}
