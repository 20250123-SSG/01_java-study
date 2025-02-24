package com.ino.section02.list.run;

import com.ino.section02.list.comparator.AscendingTitle;
import com.ino.section02.list.dto.Music;

import java.util.*;

public class Application4 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("banana", "apple", "orange", "mango", "grape");

        Collections.sort(stringList);

        List<Music> list = new ArrayList<>();
        System.out.println("init list : " + list);

        list.add(new Music("bood bye", "hyosin1"));
        list.add(new Music("bood ", "hyosin2"));
        list.add(new Music(" bye", "hyosin3"));
        list.add(new Music("123", "hyosin4"));

        Collections.sort(list);
        System.out.println(list);


        Collections.sort(list, new AscendingTitle());

        list.sort(new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o2.getArtist().compareTo(o1.getArtist());
            }
        });
        System.out.println(list);

        Collections.sort(list, ((o1, o2) -> o2.getTitle().compareTo(o1.getTitle())));


        System.out.println("custom sort : " + list);

    }
}
