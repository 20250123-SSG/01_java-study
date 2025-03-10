package com.minkook.section02.list.compartor;

import com.minkook.section02.list.dto.Music;

import java.util.Comparator;

public class AscendingTitle implements Comparator<Music> {

    @Override
    public int compare(Music o1, Music o2) {
        return o2.getTitle().compareTo(o1.getTitle());
    }
}