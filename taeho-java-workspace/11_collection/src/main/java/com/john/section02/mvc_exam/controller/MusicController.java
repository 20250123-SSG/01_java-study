package com.john.section02.mvc_exam.controller;

import com.john.section02.mvc_exam.comparator.AscendingTitle;
import com.john.section02.mvc_exam.comparator.DescendingTitle;
import com.john.section02.mvc_exam.dto.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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

    public int modifyMusic(String title, String newTitle, String newArtist) {
        int result = 0;
        for (Music m : list) {
            if (m.getTitle().equals(title)) {
                m.setTitle(newTitle);
                m.setArtist(newArtist);
                result++;
            }
        }
        return result;
    }

    public List<Music> searchMusicByKerword(String kerword) {
        List<Music> searchList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().contains(kerword)) {
                searchList.add(list.get(i));
            }
        }
        return searchList;
    }

    public List<String> searchMusicByArtist(String artist) {
        List<String> searchList = new ArrayList<>();
        for (Music m : list) {
            if (m.getArtist().equals(artist)) {
                searchList.add(m.getTitle());
            }
        }
        return searchList;
    }

    public int selectCountMusic(String title) {
        int count = 0;
        for (Music m : list) {
            if (m.getTitle().contains(title)) {
                count++;
            }
        }
        return count;
    }


    public List<Music> selectSortMusic(int menu) {
        List<Music> sortList = new ArrayList<>();
        sortList.addAll(list);

        if (menu == 1) {
            Collections.sort(sortList);
        } else if (menu == 2) {
            sortList.sort(new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    return 0;
                }
            });
        } else if (menu == 3) {
            sortList.sort(new AscendingTitle());
        } else if (menu == 4) {
            sortList.sort(new DescendingTitle());
        }
        return sortList;
    }
}
