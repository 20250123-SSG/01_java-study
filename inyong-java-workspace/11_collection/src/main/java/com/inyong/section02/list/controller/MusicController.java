package com.inyong.section02.list.controller;

import com.inyong.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

// 사용자의 요청을 처리해주는 클래스
public class MusicController {
    private List<Music> list = new ArrayList<>();
    {
        list.add(new Music("Good Bye", "박효신"));
        list.add(new Music("술이 달다", "에픽"));
        list.add(new Music("밥이 달다", "강보람"));
    }

    /**
     *
     * @param title 새로이 추가할 곡의 곡명
     * @param artist 새로이 추가할 곡의 가수명
     * @return 성공여부
     */
    public Boolean insertMusic(String title, String artist) {
        boolean result = list.add(new Music(title, artist));

        return result;
    }

    public List<Music> selectMusicList() {
        return list;
    }

    public int deleteMusic(String title){
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTitle().equals(title)){
                list.remove(i);
                result++;
                break;
            }
        }

        return result;
    }

}
