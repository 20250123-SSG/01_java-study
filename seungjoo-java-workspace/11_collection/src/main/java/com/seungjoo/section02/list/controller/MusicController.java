package com.seungjoo.section02.list.controller;

import com.seungjoo.section02.list.comparator.AscendingTitle;
import com.seungjoo.section02.list.comparator.DescendingTitle;
import com.seungjoo.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 사용자의 요청 처리해주는 클래스
public class MusicController {

    private List<Music> list = new ArrayList<>();
    {
        list.add(new Music("Good Bye", "박효신"));
        list.add(new Music("술이 달다", "에픽하이"));
        list.add(new Music("밥이 달다", "강보람"));
    }

    /**
     * 신규 곡 추가 요청 처리
     * @param title     새로이 추가할 곡의 곡명
     * @param artist    새로이 추가할 곡의 가수명
     * @return          성공 여부
     */
    public boolean insertMusic(String title, String artist){
        boolean result = list.add(new Music(title, artist));
        return result;
    }

    /**
     * 전체 곡 조회 요청 처리
     * @return  전체 곡 정보가 담겨있는 list
     */
    public List<Music> selectMusicList(){
        return list;
    }

    public int deleteMusic(String title){

        int result = 0;
        for(int i=0; i<list.size(); i++){
            if( list.get(i).getTitle().equals(title) ){
                list.remove(i);
                //System.out.println("성공적으로 삭제되었습니다.");
                result++;
                break;
            }
        }

        // result == 0(삭제할 곡을 못찾음) | 1(성공적으로 삭제 된거임)
        return result;
    }


    public int updateMusic(String title, String uptitle,String artist){
        int result = 0;
        for(int i=0; i<list.size(); i++){
            if( list.get(i).getTitle().equals(title) ){
                list.get(i).setArtist(artist);
                list.get(i).setTitle(uptitle);
                result++;
            }
        }
        if(result>0) {
            System.out.println("수정할 곡을 찾았습니다.");
        }else{
            System.out.println("수정할 곡을 찾지 못하였습니다.");
        }
        return result;
    }

    public List<Music> serarchMusicByKeyword(String keyword){
        //검색된 Music객체를 차곡차곡 담을 searchList
        List<Music> searchList=  new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTitle().contains(keyword)){
                searchList.add(list.get(i));
            }

        }
        return searchList;
    }


    public List<Music> searchByArtist(String artist){
        List<Music> searchList=  new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getArtist().equals(artist)){
                searchList.add(list.get(i));
            }
        }
        return searchList;
    }
     public int searchCount(String title){
         List<Music> searchList=  new ArrayList<>();
         int cnt = 0;
         for (int i = 0; i < list.size(); i++) {
             if(list.get(i).getTitle().equals(title)){
                 cnt++;
             }
         }
         return cnt;
     }

     public List<Music> sortMusic(int menu){

        //복사본 리스트 만들기
         List<Music> sortList = new ArrayList<>();
         sortList.addAll(list);

        if(menu == 1){
            Collections.sort(sortList);

        }else if(menu == 2){
            sortList.sort(new Comparator<Music>(){
                @Override
                public int compare(Music o1, Music o2){
                    return o2.getArtist().compareTo(o1.getArtist());
                }
            });

        }else if(menu == 3){
            sortList.sort(new AscendingTitle());

        }else{
            sortList.sort(new DescendingTitle());

        }
        return sortList;
     }



}