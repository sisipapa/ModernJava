## Stream  
자바의 컬렉션 클래스에는 같은 기능의 메서드들이 중복해서 정의되어 있다. List를 정렬할 때는 Collection.sort()를 사용하고, 배열을 정렬할 때는 Arrays.sort()를 사용한다.    
Collection 마다 다른 방식으로 다루어야하는 문제점을 해결해주는 것이 Stream 이다.  

## Stream 만들기  
```java  
public static void streamTest1(){
        // Arrays.asList(String[] => List<String>)
        String[] strArr = {"bbb", "ddd", "aaa", "ccc"};
        List<String> strList = Arrays.asList(strArr);

        Stream<String> strStream1 = strList.stream();       // List => Stream
        Stream<String> strStream2 = Arrays.stream(strArr);  // Arrays => Stream

        strStream1.sorted().forEach(System.out::println);
        strStream2.sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
```

## 특정 범위의 정수 Stream  
요소의 타입이 T인 스트림은 오토박싱/언박싱의 비효율을 줄이기 위해 데이터 소스의 요소를 기본형으로 다루는 IntStream, LongStream, DoubleStream이 제공된다.
```java  
public static void streamTest2(){
    System.out.println("###range");
    IntStream.range(0, 10).forEach(num -> System.out.print(" " + num));
    System.out.println("");
    System.out.println("###rangeClosed");
    IntStream.rangeClosed(0, 10).forEach(num -> System.out.print(" " + num));
}
```

## Stream.iterate, Stream.generate  
Stream 클래스의 iterate()와 generate()는 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성한다. 아래 예제는 무한스트림이 되지 않도록 limit를 지정했다.  
```java  

public static void streamTest3(){
    Stream<Integer> evenStream = Stream.iterate(0, n->n+2);
    evenStream.limit(5).forEach(System.out::println);
}

public static void streamTest4(){
    Stream<Double> randomStream = Stream.generate(Math::random);
    randomStream.limit(5).forEach(System.out::println);
}
```

## Stream 연결 및 중복제거  
Stream의 static 메소드인 concat()을 사용해서 두 스트림을 하나로 연결하고 distinct()를 사용해서 중복을 제거한다.  
```java

public static void streamTest5(){
    String[] str1 = {"1", "2", "3", "1", "3"};
    String[] str2 = {"A", "B", "C", "B", "Z", "D"};

    Stream<String> strs1 = Stream.of(str1);
    Stream<String> strs2 = Stream.of(str2);
    Stream<String> strs3 = Stream.concat(strs1, strs2);   

    System.out.println("Stream 연결 중복제거");
    strs3.distinct().forEach(System.out::println);

}
```  

## Stream 요소 걸러내기(filter)  
filter는 말 그대로 특정조건으로 스트림의 컨텐츠를 필터링하는 것입니다.  
같은 조건을 filter 하나로 사용, 두개로 사용했을 때의 예제입니다.  
```java  
public static void basic1(){
    // 하나의 filter를 사용
    IntStream intStream1 = IntStream.rangeClosed(1, 10);
    intStream1.filter(i -> i%2!=0 && i%3!=0).forEach(System.out::println);

    // 두개의 filter를 사용
    IntStream intStream2 = IntStream.rangeClosed(1, 10);
    intStream2.filter(i -> i%2!=0).filter(i -> i%3!=0).forEach(System.out::println);
}
```  

## Stream item 변경(map)  
Map은 각각의 item을 변경하여 새로운 컨텐츠를 생성하는 기능입니다.  
```java  
public static void basic3(){
    List<String> list = List.of("a1", "a2", "b1", "b2", "c2", "c1", "c3");
    Stream<String> stream = list.stream();
    stream.map(String::toUpperCase).forEach(System.out::println);
}
```  

## Stream flatMap
FlatMap은 여러개의 스트림을 한개의 스트림으로 합쳐줍니다. 복잡한 스트림을 간단한 스트림으로 변경되는데 사용할 수 있습니다.  
```java  
public static void basic4(){
    String[][] arrays = new String[][]{ {"aa1", "aa2"}, {"bb1", "bb2"}, {"cc1", "cc2", "cc3"} };
    Stream<String[]> stream1 = Arrays.stream(arrays);
    Stream<String> stream2 = stream1.flatMap(s -> Arrays.stream(s));
    stream2.forEach(System.out::println);
}
```


## Stream 정렬(sort)  

```java   
public static void basic2(){
    System.out.println("===기본정렬");
    Stream<String> strStream1 = Stream.of("FFFFFFF", "ccc", "A", "BB", "eeeee", "dddd");
    strStream1.sorted().forEach(System.out::print);
    System.out.println("\n===============================================================================");

    System.out.println("###기본정렬 역순");
    Stream<String> strStream2 = Stream.of("FFFFFFF", "ccc", "A", "BB", "eeeee", "dddd");
    strStream2.sorted(Comparator.reverseOrder()).forEach(System.out::print);
    System.out.println("\n===============================================================================");

    System.out.println("###대소문자 구분없이");
    Stream<String> strStream3 = Stream.of("FFFFFFF", "ccc", "A", "BB", "eeeee", "dddd");
    strStream3.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::print);
    System.out.println("\n===============================================================================");

    System.out.println("###길이 정렬");
    Stream<String> strStream4 = Stream.of("FFFFFFF", "ccc", "A", "BB", "eeeee", "dddd");
    strStream4.sorted(Comparator.comparing(String::length)).forEach(System.out::print);
    System.out.println("\n===============================================================================");
}
```

## Stream filter,map의 활용
반복문과 제어문으로 된 프로그램을 Stream,filter,map 을 활용해서 변경한 예제입니다.  
```java
/**
 * 반복문/제어문을 활용
 */
public static void method1(){
    Integer result = null;
    for (final Integer number : NUMBERS) {
        if (number > 3 && number < 9) {
            final Integer newNumber = number * 2;
            if (newNumber > 10) {
                result = newNumber;
                break;
            }
        }
    }
    System.out.println("\n==================================");
    System.out.println("반복문 제어문의 결과: " + result);
}

/**
 * Stream lamda1
 */
public static void method2(){
    System.out.println("\n==================================");
    System.out.println("Stream filter와 map을 활용한 결과 lamda1 : " +
            NUMBERS.stream()
                    .filter(number -> number > 3)
                    .filter(number -> number < 9)
                    .map(number -> number * 2)
                    .filter(number -> number > 10)
                    .findFirst()
    );
}

/**
 * Stream lamda2
 */
public static void method3(){
    System.out.println("\n==================================");
    System.out.println("Stream filter와 map을 활용한 결과 lamda2 : " +
            NUMBERS.stream()
                .filter(number -> {
                return number > 3;
                })
                .filter(number -> {
                return number < 9;
                })
                .map(number -> {
                return number * 2;
                })
                .filter(number -> {
                return number > 10;
                })
                .findFirst()
    );
    System.out.println("\n==================================");
}
```  

## Optional 생성 및 내부객체 접근
Optional은 제네릭 클래스로 객체를 감싸는 래퍼 클래스이다.  
Optional 타입의 객체에는 모든 타입의 참조변수를 담을 수있다.   
Optional 클래스는 null 값을 처리할 때 많이 활용된다.  

Optional.of를 사용해서 String의 래퍼클래스로 생성하고 Optional.get을 사용해서 Optional객체 내부의 String객체에 접근한다.  
```java  
public static void basic1(){
    String value = "This is Optional";
    Optional<String> optionalStr = Optional.of(value);
    System.out.println("basic1 result : " + optionalStr.get());
}
```  
  
## null을 포함하는 Optional 객체 생성  
Optional.of()는 null이 아닌 객체만 사용하다.  
null값을 포함하는 객체를 Optional 객체를 래퍼클래스로 생성하기 위해서는 아래 두가지 방법이 있다.     
```java  
public static void basic2(){
    // 방법1 - Optional.ofNullable
    String nullValue = null;
    Optional<String> nullOptionalStr = Optional.ofNullable(nullValue);
    try{
        System.out.println(nullOptionalStr.get());
    }catch(Exception e){
        e.printStackTrace();
    }
}
```  
```java  
public static void basic3(){
    // 방법2 - Option.empty
    Optional<String> nullOptionalStr = Optional.empty();
    try{
        System.out.println(nullOptionalStr.get());
    }catch(Exception e){
        e.printStackTrace();
    }
}
```    
  
## isPresent(),ifPresent() 내부 객체 존재 여부확인  
```java  
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
```

## orElse - Optional이 null인 경우 orElse()의 param을 리턴  
```java  
public static void basic5(){
    Optional<String> optionalStr = Optional.of("This is not null String");
    Optional<String> nullOptionalStr = Optional.ofNullable(null);

    String optionalStr2 = optionalStr.orElse("optionalStr 대체 String 입니다.");
    String nullOptionalStr2 = nullOptionalStr.orElse("nullOptionalStr 대체 String 입니다.");

    System.out.println("optionalStr2 : " + optionalStr2);           // This is not null String
    System.out.println("nullOptionalStr2 : " + nullOptionalStr2);   // nullOptionalStr 대체 String 입니다.
}
```

## orElseGet - Optional이 null인 경우 특정 함수를 실행하고 그 결과를 리턴
```java  
public static void basic6(){
    Optional<String> optionalStr = Optional.of("This is not null String");
    Optional<String> nullOptionalStr = Optional.ofNullable(null);

    String optionalStr2 = optionalStr.orElseGet(() -> "[orElseGet] This is not null String");
    String nullOptionalStr2 = nullOptionalStr.orElseGet(() -> "[orElseGet] This is null String");

    System.out.println("optionalStr2 : " + optionalStr2);// This is not null String
    System.out.println("nullOptionalStr2 : " + nullOptionalStr2); // [orElseGet] This is null String
}
```  

## orElseThrow - Optional이 null인 경우 예외를 던진다.
```java  
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
```  

## 참고  
[Java8의 Optional 사용 방법 및 예제](https://codechacha.com/ko/java8-stream-optional/)   
[자바의 정석 - 스트림(Stream)](https://ryan-han.com/post/java/java-stream/)    


[SISIPAPA정리노트-StreamExample1](https://sisipapa.github.io/blog/2021/04/22/Modern-Java-Stream1)  
[SISIPAPA정리노트-StreamExample2](https://sisipapa.github.io/blog/2021/04/22/Modern-Java-Stream2)  
[SISIPAPA정리노트-StreamExample3](https://sisipapa.github.io/blog/2021/04/22/Modern-Java-Stream3)  

