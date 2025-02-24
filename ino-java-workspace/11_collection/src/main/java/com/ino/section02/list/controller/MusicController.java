package com.ino.section02.list.controller;

import com.ino.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicController {

    private List<Music> list = new ArrayList<>();
    {
        list.add(new Music("byebye", "park"));
        list.add(new Music("byebye1", "mun"));
        list.add(new Music("byebye2", "lee"));
        list.add(new Music("byebye3", "kim"));
    }

    public boolean insertMusic(String name, String artist) {
        boolean flag = list.add(new Music(name, artist));
        return flag;
    }

    public List<Music> selectMusic() {
        return list;
    }

    public boolean deleteMusic(String title) {

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTitle().equals(title)) {
                list.remove(i);
                result++;
                break;
            }
        }
        return result == 0 ? false : true;
    }
}
