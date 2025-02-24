package com.john.section02.mvc_exam.controller;

import com.john.section02.mvc_exam.dto.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 사용자의 요청을 처리해주는 클래스
public class MusicController {
    private List<Music> list = new ArrayList<>();

    {
        list.add(new Music("김", "김이박"));
        list.add(new Music("하입보이", "뉴진스"));
        list.add(new Music("인생", "켄트벡"));
    }

    /**
     * @param title  곡명
     * @param artist 작사
     * @return 성공여부
     */
    public boolean insertMusic(String title, String artist) {
//        boolean result = list.add(new Music(title, artist));
//        return result;
        return list.add(new Music(title, artist));
    }

    /**
     * @return 곡의 전체 목록
     */
    public List<Music> selectMusic() {
        return list;
    }

    public Music selectSingleMusic(int musicId) {
        return list.get(musicId);
    }

    public boolean deleteMusic(String title) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public int selectMusicByTitle(String title) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateMusic(int Id, String Title, String artist) {
        list.set(Id, new Music(Title, artist));
        return true;
    }
}
