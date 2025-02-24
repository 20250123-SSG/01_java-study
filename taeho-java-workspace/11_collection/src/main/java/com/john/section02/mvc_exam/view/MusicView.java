package com.john.section02.mvc_exam.view;

import com.john.section02.mvc_exam.controller.MusicController;
import com.john.section02.mvc_exam.dto.Music;

import java.util.List;
import java.util.Scanner;

public class MusicView {
    private MusicController musicController = new MusicController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        while (true) {
            System.out.println("\n 음악관리 프로그램");
            System.out.println("1. 신규 곡 추가");
            System.out.println("2. 전체 곡 조회");
            System.out.println("3. 특정 곡 삭제");
            System.out.println("4. 특정 곡 수정");
            System.out.println("5. 특정 곡 검색");
            System.out.println("0. 프로그램 종료");
            System.out.print(">> 메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    insertMusic();
                    break;
                case 2:
                    selectMusic();
                    break;
                case 3:
                    deleteMusic();
                    break;
                case 4:
                    updateMusic();
                    break;
                case 5:
                    selectSingleMusic();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }
    }

    public void insertMusic() {
        System.out.println("\n== 신규 곡 추가 ==");
        System.out.print("제목 입력: ");
        String title = sc.nextLine();
        System.out.print("가수 입력: ");
        String artist = sc.nextLine();

        boolean result = musicController.insertMusic(title, artist);
        if (result) {
            System.out.println("곡이 정상적으로 추가되었습니다.");
        } else {
            System.out.println("곡이 추가되지 않았습니다..");
        }
    }

    public void selectMusic() {
        System.out.println("\n== 전체 곡 리스트 ==");
        List<Music> musicList = musicController.selectMusic();
        if (musicList.isEmpty()) {
            System.out.println("현재 등록된 곡이 없습니다.");
        } else {
            for (Music m : musicList) {
                System.out.println(m);
            }
        }
    }

    public void deleteMusic() {
        System.out.println("\n== 곡 삭제 ==");

        System.out.print("삭제하고자 하는 곡명: ");
        String title = sc.nextLine();

        boolean result = musicController.deleteMusic(title);
        if (result) {
            System.out.println("성공적으로 삭제됐습니다.");
        } else{
            System.out.println("해당 곡을 찾지 못했습니다.");
        }
    }
    
    public void selectSingleMusic(){
        System.out.println("\n== 곡 검색 ==");

        System.out.print("검색하고자 하는 곡명: ");
        String title = sc.nextLine();
        int musicId = musicController.selectMusicByTitle(title);
        if (musicId == -1) {
            System.out.println("해당 곡을 찾지 못했습니다.");
        } else{
            Music m = musicController.selectSingleMusic(musicId);
            System.out.println(m);
        }
    }

    public void updateMusic() {
        System.out.println("\n== 곡 정보 수정 ==");

        System.out.print("수정하고자 하는 곡명: ");
        String title = sc.nextLine();

        int musicId = musicController.selectMusicByTitle(title);
        if (musicId == -1) {
            System.out.println("해당 곡을 찾지 못했습니다.");
        } else{
            System.out.print("수정하려는 곡명을 입력하세요 ");
            String newTitle = sc.nextLine();
            System.out.print("수정하려는 아티스트명을 입력하세요 ");
            String newArtist = sc.nextLine();
            boolean result = musicController.updateMusic(musicId, newTitle, newArtist);
            System.out.println("정상적으로 수정되었습니다");
        }
    }
}

