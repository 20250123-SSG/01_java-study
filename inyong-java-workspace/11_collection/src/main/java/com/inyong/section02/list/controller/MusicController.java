package com.inyong.section02.list.controller;

import com.inyong.section02.list.comparator.AscendingTitle;
import com.inyong.section02.list.comparator.DescendingTitle;
import com.inyong.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * @param title  새로이 추가할 곡의 곡명
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

    public int deleteMusic(String title) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                list.remove(i);
                result++;
                break;
            }
        }

        return result;
    }


    public int updateMusic(String title, String upTitle, String upArtist) {
        int result = 0;
        for (Music m : list) {
            if (m.getTitle().equals(title)) {
                m.setTitle(upTitle);
                m.setArtist(upArtist);
                result++;
            }
        }
        return result;
    }

    public List<Music> searchMusicByKeyword(String keyword) {
        List<Music> searchList = new ArrayList<>(); // 현재는 빈 상태

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().contains(keyword)) {
                searchList.add(list.get(i));
            }
        }
        //searchList == 텅비어있는 상태 | 검색된 Music객체가 담겨있는 상태

        return searchList;
    }

    public List<Music> searchMusicByArtist(String keyword) {
        List<Music> searchList = new ArrayList<>(); // 현재는 빈 상태

        for (Music music : list) {
            if (music.getArtist().contains(keyword)) {
                searchList.add(music);
            }
        }
        //searchList == 텅비어있는 상태 | 검색된 Music객체가 담겨있는 상태

        return searchList;
    }

    public int searchMusicCount(String keyword) {
        List<Music> searchList = new ArrayList<>(); // 현재는 빈 상태

        for (Music music : list) {
            if (music.getTitle().contains(keyword)) {
                searchList.add(music);
            }
        }

        return searchList.size();
    }

    public List<Music> sortMusic(int menu) {
        /*
        Collections.sort(리스트)
         : 리스트 내의 요소간에 비교시 요소 클래스에 정의되어있는 compareTo 메소드 동작
        Collections.srt(리스트, comparator 객체)
         : 리스트 내의 요소간에 비교시 Comparator 클래스에 정의되어있는 comepare 메소드 동작
        리스트.sort(Comparator 객체)
         : 리스트 내의 요소간에 비교시 Comparator 클래스에 정의되어있는 comepare 메소드 동작

        // 복사본 리스트 만들기
     */
        List<Music> sortList = new ArrayList<>();

        sortList.addAll(list); // 복제

        if (menu == 1) {
            Collections.sort(sortList);
        } else if (menu == 2) {
            sortList.sort(new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    return o2.getArtist().compareTo(o1.getArtist());
                }
            });
        } else if (menu == 3) {
            sortList.sort(new AscendingTitle());
        } else {
            sortList.sort(new DescendingTitle());
        }

        return sortList;
    }


}
