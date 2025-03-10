package com.younggalee.section03;

import com.younggalee.dto.Person;
import com.younggalee.dto.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {

         /*
            실습1. 아래의 이름들 중 길이가 4글자 이상인 이름만 대문자로 변환하여 새로운 List에 담아 출력해보시오.
         */
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Tom", "Alice");
        List<String> filteredNames = names.stream()
                .filter(name -> name.length() >= 4)
                .map(String::toUpperCase) // name -> name.toUpperCase()
                .collect(Collectors.toList());

        System.out.println(filteredNames);

        /*
            실습2. 아래의 숫자들 중 짝수만 선택해서 제곱하여 합계를 계산하시오.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(sumOfSquares); // 220 (4 + 16 + 36 + 64 + 100)

        /*
            실습3. 아래의 사람들 중 나이가 20세 이상인 사람들의 이름을 알파벳 순으로 정렬하여
                   새로운 List에 담아 출력해보시오.
         */
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Jane", 30),
                new Person("Adam", 18),
                new Person("Eve", 35)
        );

        List<String> adultNames = people.stream()
                .filter(person -> person.getAge() >= 20)
                .map(Person::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(adultNames);


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

        Map<String, List<Product>> productsByCategory = products.stream()
                .filter(product -> product.getPrice() >= 100000)
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println(productsByCategory);

    }
}