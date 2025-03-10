package com.ino.section02.list.view;

import com.ino.section02.list.controller.MusicController;
import com.ino.section02.list.dto.Music;

import java.util.List;
import java.util.Scanner;

public class MusicView {

    private MusicController mc = new MusicController();
    private Scanner sc = new Scanner(System.in);
    public void removeMusic(){
        System.out.println("\n== 특정 곡 삭제");
        System.out.println("삭제 곡 명");
        String title = sc.nextLine();

        mc.deleteMusic(title);
    }
    public void addMusic() {
        String name = sc.nextLine();
        String artist = sc.nextLine();
        if (mc.insertMusic(name, artist)) {
            System.out.println("added successfully");
        }
        else {
            System.out.println("error occurred");
        }
    }
    public void selectMusic() {
        List<Music> mList = mc.selectMusic();
    }
    public void modMusic() {
        System.out.println("특정 곡 수정");
        System.out.println("수정 곡 명");
        String name = sc.nextLine();
        System.out.println("수정 내용 곡명");
        String upName = sc.nextLine();
        System.out.println("수정 내용 가수명");
        String upArtist = sc.nextLine();
        int result = mc.modMusic(name, upName, upArtist);
        if (result > 0) {
            System.out.println("modified successfully");
        }
        else {
            System.out.println("can't find for modify");
        }
    }

    public void searchMusic() {
        System.out.println("search music");
        System.out.print("type search music name");
        String keyword = sc.nextLine();
        List<Music> m = mc.searchMusicByKeyword(keyword);
        if (m.isEmpty()) {
            System.out.println("it's empty");
        }
        else {
            for (Music music : m) {
                System.out.println(music);
            }
        }
    }
    public void mainMenu() {
        while (true) {
            System.out.println("\n musinc control program");
            System.out.println("1. add new music");
            System.out.println("2. search all music");
            System.out.println("3. delete specify music");
            System.out.println("4. edit spec music");
            System.out.println("5. search spec music");
            System.out.println("6. search musics by singer");
            System.out.println("7. count spec songs");
            System.out.println("0. exit program");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    addMusic();
                    break;
                case 2:
                    selectMusic();
                    break;
                case 3:
                    removeMusic();
                    break;
                case 4:
                    modMusic();
                    break;
                case 5:
                    searchMusic();
                    break;
                case 6:
                    searchMusicBySinger();
                    break;
                case 7:
                    countSpecSongs();
                    break;
                case 0:
                    break;
            }
        }
    }

    private void countSpecSongs() {
        System.out.println("countSpecSongs");
        System.out.print("type countSpecSongs");
        String keyword = sc.nextLine();
        int m = mc.countMusicByKeyword(keyword);
        System.out.println(m + "개");
    }

    private void searchMusicBySinger() {
        System.out.println("search music");
        System.out.print("type singer name");
        String singer = sc.nextLine();
        List<Music> m = mc.searchMusicBySinger(singer);
        if (m.isEmpty()) {
            System.out.println("it's empty");
        }
        else {
            for (Music music : m) {
                System.out.println(music);
            }
        }
    }


}
