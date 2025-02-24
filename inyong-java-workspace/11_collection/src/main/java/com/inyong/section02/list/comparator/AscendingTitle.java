package com.inyong.section02.list.comparator;

import com.inyong.section02.list.dto.Music;

import java.util.Comparator;

public class AscendingTitle implements Comparator<Music> {

    @Override
    public int compare(Music o1, Music o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
