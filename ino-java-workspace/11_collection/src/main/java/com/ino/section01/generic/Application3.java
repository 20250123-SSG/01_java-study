package com.ino.section01.generic;

import com.ino.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        List<Music> list = new ArrayList<>();
        System.out.println("init list : " + list);

        list.add(new Music("bood bye", "hyosin1"));
        list.add(new Music("bood ", "hyosin2"));
        list.add(new Music(" bye", "hyosin3"));
        list.add(new Music("123", "hyosin4"));

        System.out.println("added list : " + list);

    }
}
