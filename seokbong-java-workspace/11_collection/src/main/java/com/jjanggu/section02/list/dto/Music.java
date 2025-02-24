package com.jjanggu.section02.list.dto;

public class Music implements Comparable<Music> {

    private String title;
    private String artist;

    public Music (){}

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }

    @Override
    public int compareTo(Music o) {
        // collections.sort 메소드 수행시 내부적으로 Music객체간에 비교할 때 호출되는 메소드
        // 즉, m1.compareTo(m2) 와 같이 호출됨
        // 이때 만약에 양수가 반환될 경우 두 객체의 순서가 변경되게 되어있음

        // ex) 가수명으로 오름차순 정렬 하도록
        //     => 앞의 Music 가수명이 크고, 뒤의 Music 가수명이 작을 경우
        //     => 순서가 바뀌어질 수 있도록 (양수를 반환시켜야됨)
        /*
        if(this.artist > o.artist){
            return 양수;
        }else {
            return 음수;
        }
        */

        return /*this.생략가능*/artist.compareTo(o.artist); // 문자열의 compareTo : 앞의 문자열이 더 클 경우 양수 반환

    }
}
