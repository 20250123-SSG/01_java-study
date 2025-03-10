package com.ino.section02.list.controller;

import com.ino.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            if (list.get(i).getTitle().equals(title)) {
                list.remove(i);
                result++;
                break;
            }
        }
        return result == 0 ? false : true;
    }

    public int modMusic(String name, String upName, String upArtist) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle() == name) {
                list.get(i).setArtist(upArtist);
                list.get(i).setTitle(upName);
                result++;
            }
        }
        return result;
    }

    public List<Music> searchMusicByKeyword(String keyword) {
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().contains(keyword) || (list.get(i).getArtist().contains(keyword))) {
                musicList.add(list.get(i));
            }
        }
        return musicList;
    }

    public int countMusicByKeyword(String keyword) {
        int n = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().contains(keyword) || (list.get(i).getArtist().contains(keyword))) {
                n++;
            }
        }
        return n;
    }

    public List<Music> searchMusicBySinger(String singer) {
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getArtist() == singer)) {
                musicList.add(list.get(i));
            }
        }
        return musicList;
    }

    public void sortMusic(int menu) {
        List<Music> sortList = list;
        if (menu == 1) {
            Collections.sort(sortList, (o1, o2) -> o2.getArtist().compareTo(o1.getArtist()));
        } else if (menu == 2) {
            Collections.sort(sortList, (o1, o2) -> o2.getTitle().compareTo(o1.getTitle()));
        } else if (menu == 3) {
            Collections.sort(sortList, Comparator.comparing(Music::getArtist));
        } else {
            Collections.sort(sortList, Comparator.comparing(Music::getTitle));
        }
    }
}
