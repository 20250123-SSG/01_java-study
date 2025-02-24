package com.kyungbae.section02.list.controller;

import com.kyungbae.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

// 사용자의 요청을 처리해주는 클래스
public class MusicController {

    private List<Music> list = new ArrayList<>();
    {
        list.add(new Music("Good Bye", "박효신"));
        list.add(new Music("막걸리나", "버스커"));
        list.add(new Music("아름다운밤", "울랄라"));
    }

    /**
     * 신규 곡 추가 요청처리
     * @param title     추가할 곡명
     * @param artist    추가할 가수명
     * @return          성공여부
     */
    public boolean insertMusic(String title, String artist){
        boolean result = list.add(new Music(title, artist));
        return result;
    }

    /**
     * 전체 곡 조회 요청 처리
     * @return 전체 곡 정보가 담겨있는 list
     */
    public List<Music> selectMusicList(){
        return list;
    }


    public int deleteMusic(String title){
//        boolean delete = false;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                list.remove(i);
//                delete = true;
                result++;
                break;
            }
        }
//        return delete;
        return result;
    }



}
