package com.ino.section03.terminal;

import com.ino.dto.Snack;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application3 {
    public static void main(String[] args) {
        List<Snack> list = List.of(new Snack("muktae", "nongsim", 2000)
                ,  new Snack("homerun", "lotte", 1500)
                ,   new Snack("sumi", "lotte", 2500)
                ,   new Snack("jagalchi", "nongsim", 700));
        Stream<String> nongsimName = list.stream().filter(snack -> snack.getBrand().equals("nongsim")).map(Snack::getName);
        String sumString = nongsimName.collect(Collectors.joining(" "));
        System.out.println(sumString);

        List<String> nameList = list.stream().filter(snack -> snack.getPrice() >= 1000).map(Snack::getName).collect(Collectors.toList());
        // 마지막 부분은 toList로 함축 가능
        Object[] nameList2 = list.stream().filter(snack -> snack.getPrice() >= 1000).map(Snack::getName).toArray();

        Map<String, List<Snack>> snackMap = list.stream().collect(Collectors.groupingBy(Snack::getBrand));

        for (String s : snackMap.keySet()) {
            System.out.println(s);
           for(Snack sn : snackMap.get(s)) {
               System.out.println(sn.toString());
           }
        }
    }
}
