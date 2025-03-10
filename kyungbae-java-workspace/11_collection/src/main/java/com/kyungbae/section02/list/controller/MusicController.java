package com.kyungbae.section02.list.controller;

import com.kyungbae.section02.list.comparator.AscendingTitle;
import com.kyungbae.section02.list.comparator.DescendingTitle;
import com.kyungbae.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 사용자의 요청을 처리해주는 클래스
public class MusicController {

    private List<Music> list = new ArrayList<>();
    {
        list.add(new Music("Good Bye", "박효신"));
        list.add(new Music("아름이나", "버스커"));
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

    /**
     * 특정 곡 삭제 처리
     * @param title 삭제할 곡 입력
     * @return 삭제 여부
     */
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

    /**
     * 특정 곡을 찾아서 곡의 곡명과 가수를 수정
     * @param title 바꾸고 싶은 곡
     * @param upTitle 곡의 새로운 이름
     * @param upArtist 곡의 새로운 가수명
     * @return 수정 여부
     */
    public int updateMusic(String title, String upTitle, String upArtist) {
        int result = 0;
        for (Music m : list) {

            if (m.getTitle().equals(title)) {
                m.setTitle(upTitle);
                m.setArtist(upArtist);
                result++;
                break;
            }
        }
        return result;
    }

    /**
     * 특정 곡을 키워드로 찾는다
     * @param keyword 찾을 곡의 키워드 입력
     * @return List 찾은 곡
     */
    public List<Music> searchMusicByKeyword(String keyword){
        List<Music> search = new ArrayList<>();
        for(Music m : list){
            if (m.getTitle().contains(keyword)){
                search.add(m);
            }
        }
        return search;
    }

    public List<String> searchArtist(String keyword){
        List<String> search = new ArrayList<>();
        for(Music m : list){
            if (m.getArtist().equals(keyword)){
                search.add(m.getTitle());
            }
        }
        return search;
    }

    public int countMusic(List<Music> result){
        return result.size();
    }

    public List<Music> sortMusic(int menu){
        // 복사본 리스트 만들기
        List<Music> sortList = new ArrayList<>();
        sortList.addAll(list); // addAll로 새로운 list에 복사하기

        // 각 방법으로 정렬하기
        if (menu == 1) {
            Collections.sort(sortList); // Music 에 가수 정렬로 Override 되어있음
        } else if (menu == 2) {
            sortList.sort(new Comparator<Music>() { // Comparator Override 동시
                @Override
                public int compare(Music o1, Music o2) {
                    return o2.getArtist().compareTo(o1.getArtist());
                }
            });
        } else if (menu == 3) {
            sortList.sort(new AscendingTitle()); // 만들어놓은 AscendingTitle 이용
        } else {
            sortList.sort(new DescendingTitle()); // 만들어놓은 DescendingTitle 이용
        }
        return sortList;
    }


}
