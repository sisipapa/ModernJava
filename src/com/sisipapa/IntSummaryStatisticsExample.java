package com.sisipapa;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class IntSummaryStatisticsExample {

    public void test1(){
        List<String> words =
                Arrays.asList("aa", "bbbb", "cccccc", "ddddd", "eeeeeeeeee");
        IntSummaryStatistics statstics = words.stream()
                                    .mapToInt(word -> (word.length()))
                                    .summaryStatistics();


        System.out.println("max: " + statstics.getMax());
        System.out.println("min: " + statstics.getMin());
        System.out.println("average: " + statstics.getAverage());
        System.out.println("count: " + statstics.getCount());
    }

    public void accept(){
        List<String> words =
                Arrays.asList("aa", "bbbb", "cccccc", "ddddd", "eeeeeeeeee");
        IntSummaryStatistics statstics = words.stream()
                                    .mapToInt(word -> word.length())
                                    .summaryStatistics();
        statstics.accept(100);

        System.out.println("max: " + statstics.getMax());
        System.out.println("min: " + statstics.getMin());
        System.out.println("average: " + statstics.getAverage());
        System.out.println("count: " + statstics.getCount());
    }

    public void combine(){
        List<String> words =
                Arrays.asList("aa", "bbbb", "cccccc", "ddddd", "eeeeeeeeee");
        IntSummaryStatistics statstics = words.stream()
                                    .mapToInt(word -> word.length())
                                    .summaryStatistics();

        List<String> words2 =
                Arrays.asList("fffffff", "ggggggggg", "h", "iiiiiiiiiiii", "jjj");
        IntSummaryStatistics statstics2 = words.stream()
                                    .mapToInt(word -> word.length())
                                    .summaryStatistics();

        statstics.combine(statstics2);

        System.out.println("max: " + statstics.getMax());
        System.out.println("min: " + statstics.getMin());
        System.out.println("average: " + statstics.getAverage());
        System.out.println("count: " + statstics.getCount());
    }

    public void summarizingInt(){
        List<String> words =
                Arrays.asList("aa", "bbbb", "cccccc", "ddddd", "eeeeeeeeee");
        IntSummaryStatistics statstics = words.stream()
                                        .collect(Collectors.summarizingInt(String::length));

        System.out.println("max: " + statstics.getMax());
        System.out.println("min: " + statstics.getMin());
        System.out.println("average: " + statstics.getAverage());
        System.out.println("count: " + statstics.getCount());
    }

    public static void main(String[] args){
        new IntSummaryStatisticsExample().test1();
//        new IntSummaryStatisticsExample().accept();
//        new IntSummaryStatisticsExample().combine();
//        new IntSummaryStatisticsExample().summarizingInt();
    }
}
