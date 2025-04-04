package com.podoseee.section03.terminal;

import com.podoseee.dto.Person;
import com.podoseee.dto.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        /*
    실습1. 아래의 이름들 중 길이가 4글자 이상인 이름만 대문자로 변환하여 새로운 List에 담아 출력해보시오.
 */
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Tom", "Alice");

        Stream<String> names = Stream.of("John", "Jane", "Adam", "Tom", "Alice")

        names.filter( name -> name.length() >= 4)
                .forEach(System.out::println);
/*
    실습2. 아래의 숫자들 중 짝수만 선택해서 제곱하여 합계를 계산하시오.
 */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

/*
    실습3. 아래의 사람들 중 나이가 25세 이상인 사람들의 이름을 알파벳 순으로 정렬하여
           새로운 List에 담아 출력해보시오.
 */
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Adam", 18),
                new Person("Eve", 35)
        );

/*
    실습4. 아래의 제품들중 가격이 10만원 이상인 제품들만
           카테고리별로 그룹화 시켜 Map<String, List<Product>> 구조로 만들어 출력해보시오.
 */
        List<Product> products = Arrays.asList(
                new Product("Phone", "Electronics", 1200000),
                new Product("Laptop", "Electronics", 800000),
                new Product("Chair", "Furniture", 50000),
                new Product("Table", "Furniture", 300000),
                new Product("Mouse", "Electronics", 80000),
                new Product("Bed", "Furniture", 1000000)
        );
    }
}
