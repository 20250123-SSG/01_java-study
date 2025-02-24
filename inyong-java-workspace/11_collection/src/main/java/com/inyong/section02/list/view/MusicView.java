package com.inyong.section02.list.view;

import com.inyong.section02.list.controller.MusicController;
import com.inyong.section02.list.dto.Music;

import java.util.List;
import java.util.Scanner;

public class MusicView {

    private MusicController mc = new MusicController();
    private Scanner sc = new Scanner(System.in);


    // 메인화면
    public void mainMenu() {

        while (true) {

            System.out.println("음악 관리 프로그램");
            System.out.println("1. 신규곡 추가");
            System.out.println("2. 곡 전체 조회");
            System.out.println("3. 특정 곡 삭제");
            System.out.println("4. 특정 곡 수정");
            System.out.println("5. 특정 곡 검색");
            System.out.println("0. 프로그램 종료");

            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu){
                case 1: inputMusic();break;
                case 2: selectMusic();break;
                case 3: removeMusic();break;
                case 4: break;
                case 5: break;
                case 0:
                    System.out.println("프로그램 종요");
                default:
                    System.out.println("잘못 선택함. 재선택 ㄱㄱ");
            }
        }



    }

    public void inputMusic() {
        System.out.println("신규 곡 추가");
        System.out.println("제목 입력: ");
        String title = sc.nextLine();
        System.out.println("가수 입력: ");
        String artist = sc.nextLine();

        boolean result = mc.insertMusic(title, artist);
        if(result){
            System.out.println("곡 추가에 실패하였습니다.");
        }else {
            System.out.println("곡 추가에 실패하였습니다. ");
        }
    }

    public void selectMusic() {
        System.out.println("전체곡 리스트");

        List<Music> list = mc.selectMusicList();

        if(list.isEmpty()){
            System.out.println("isEmpty");
        }else {
            for (Music music : list) {
                System.out.println(music);
            }
        }
    }

    public void removeMusic() {
        System.out.println("\n특정 곡 삭제");

        System.out.println("삭제 하고자 하는 곡명");
        String title = sc.nextLine();

        int result = mc.deleteMusic(title);

        if( result > 0){
            System.out.println("성공적으로 삭제");
        }else{
            System.out.println("삭제할 곡을 찾지 못했습니다.");
        }

    }

}
