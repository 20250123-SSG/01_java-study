package com.pch.section02.run;

import com.pch.section02.comparator.DescendingTitle;
import com.pch.section02.dto.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application04 {
    public static void main(String[] args) {
        System.out.println("정렬 후 musicList : ");
        List<Music> musicList = new ArrayList<>();

        Collections.sort(musicList, new DescendingTitle());

        Collections.sort(musicList, new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    }
}
