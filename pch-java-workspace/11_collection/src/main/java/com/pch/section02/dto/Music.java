package com.pch.section02.dto;

public class Music {
    private String title;

    public Music() {
    }

    public Music(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                '}';
    }
}
