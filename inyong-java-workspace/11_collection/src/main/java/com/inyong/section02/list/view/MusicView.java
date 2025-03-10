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
            System.out.println("6. 가수명 곡 검색");
            System.out.println("7. 특정 곡 개수 검색");
            System.out.println("0. 프로그램 종료");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    inputMusic();
                    break;
                case 2:
                    selectMusic();
                    break;
                case 3:
                    removeMusic();
                    break;
                case 4:
                    modifyMusic();
                    break;
                case 5:
                    searchMusic();
                    break;
                case 6:
                    searchArtist();
                    break;
                case 7:
                    searchMusicCount();
                    break;
                case 8:
                    sortMusic();
                    break;
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
        if (result) {
            System.out.println("곡 추가에 실패하였습니다.");
        } else {
            System.out.println("곡 추가에 실패하였습니다. ");
        }
    }

    public void selectMusic() {
        System.out.println("전체곡 리스트");

        List<Music> list = mc.selectMusicList();

        if (list.isEmpty()) {
            System.out.println("isEmpty");
        } else {
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

        if (result > 0) {
            System.out.println("성공적으로 삭제");
        } else {
            System.out.println("삭제할 곡을 찾지 못했습니다.");
        }
    }

    public void modifyMusic() {
        System.out.println("\n== 특정 곡 수정 ==");
        System.out.println("수정하고자하는 곡명 : ");
        String title = sc.nextLine();
        System.out.println("수정 내용(곡명): ");
        String upTitle = sc.nextLine();
        System.out.print("수정 내용(가수명): ");
        String upArtist = sc.nextLine();

        int result = mc.updateMusic(title, upTitle, upArtist);

        if (result > 0) {
            System.out.println("성공적으로 수정");
        } else {
            System.out.println("수정 실패");
        }
    }

    public void searchMusic() {
        System.out.println("\n== 특정 곡 검색 == ");

        System.out.println("검색할 곡명(키워드도 가능): ");
        String keyword = sc.nextLine();

        List<Music> searchList = mc.searchMusicByKeyword(keyword);

        if (searchList.isEmpty()) {
            System.out.println("검색된 결과가 없습니다");
        } else {
            for (Music m : searchList) {
                System.out.println(m);
            }
        }
    }

    public void searchArtist() {
        System.out.println("\n== 특정 곡 검색 == ");

        System.out.println("검색할 가수(키워드도 가능): ");
        String keyword = sc.nextLine();

        List<Music> searchList = mc.searchMusicByArtist(keyword);

        if (searchList.isEmpty()) {
            System.out.println("검색된 결과가 없습니다");
        } else {
            for (Music m : searchList) {
                System.out.println(m);
            }
        }
    }

    public void searchMusicCount() {
        System.out.println("\n=== 특정 곡 갯수 검색 === ");

        System.out.println("검색할 곡명: ");
        String keyword = sc.nextLine();
        int result = mc.searchMusicCount(keyword);

        if (result == 0) {
            System.out.println("검색된 결과가 없습니다");
        } else {
            System.out.printf("검색된 곡의 갯수는 %d개 입니다.", result);

        }
    }

    public void sortMusic() {
        System.out.println("=== 곡 정렬 조회 ===");
        System.out.println("1. 가수명 오름차순");
        System.out.println("2. 가수명 내림차순");
        System.out.println("3. 곡명 오름차순");
        System.out.println("4. 곡명 내림차순");
        System.out.print(">>메뉴 선택: ");
        int menu = sc.nextInt();

        mc.sortMusic(menu);
        List<Music> list = mc.sortMusic(menu);

        for (Music m : list) {
            System.out.println(m);
        }

    }

}
