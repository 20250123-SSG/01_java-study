package com.john.section02.mvc_exam.comparator;


import com.john.section02.mvc_exam.dto.Music;

import java.util.Comparator;

public class DescendingTitle implements Comparator<Music> {
    @Override
    public int compare(Music o1, Music o2) {
        return o2.getTitle().compareTo(o1.getTitle());
    }
}
