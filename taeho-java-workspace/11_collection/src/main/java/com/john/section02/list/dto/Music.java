package com.john.section02.list.dto;

public class Music implements Comparable<Music> {
    private String title;
    private String artist;

    public Music() {
    }

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
    public int compareTo(Music o){
        // Collections. sort 메서드 수행시 내부적으로 Music 객체간 비교할 때 호출되는 메서드(m1.compareTo(m2))
        // 양수 반환 시 두 객체의 순서가 변경됨

        return artist.compareTo(o.artist);
    }
}
