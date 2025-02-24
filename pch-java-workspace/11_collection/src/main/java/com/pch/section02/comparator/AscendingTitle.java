package com.pch.section02.comparator;

import com.pch.section02.dto.Music;

import java.util.Comparator;

public class AscendingTitle implements Comparator<Music> {
    @Override
    public int compare(Music o1, Music o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
