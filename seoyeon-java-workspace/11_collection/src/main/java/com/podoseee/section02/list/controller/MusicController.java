package com.podoseee.section02.list.controller;

import com.podoseee.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

// 사용자의 요청 처리해주는 클래스
public class MusicController {

    private List<Music> list = new ArrayList<>();

    {
        list.add(new Music("음악의 신", "세븐틴"));
        list.add(new Music("스티커사진", "20학번"));
        list.add(new Music("사건의 지평선", "윤하"));
    }

    /**
     * 신규 곡 추가 요청 처리
     *
     * @param title  새로이 추가할 곡의 곡명
     * @param artist 새로이 추가할 곡의 가수명
     * @return 성공 여부
     */
    public boolean insertMusic(String title, String artist) {
        boolean result = list.add(new Music(title, artist));
        return result;
    }

    /**
     * 전체 곡 조회 요청 처리
     *
     * @return 전체 곡 정보가 담겨있는 list
     */
    public List<Music> selectMusicList() {
        return list;
    }


    /**
     * 삭제할 곡 입력받고 삭제 처리
     * @param title     삭제할 곡명
     */
    public int deleteMusic(String title) { // 정수값이 반환되는 메소드
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                list.remove(i);
                //System.out.println("성공적으로 삭제되었습니다.");
                result++;
                break;
            }
        }

        // result == 0(삭제할 곡을 못찾음) | 1(성공적으로 삭제 된거임)
        return result;
    }

}
