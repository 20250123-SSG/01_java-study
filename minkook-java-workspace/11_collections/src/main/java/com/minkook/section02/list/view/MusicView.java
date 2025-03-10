package com.minkook.section02.list.view;

import com.minkook.section02.list.controller.MusicController;
import com.minkook.section02.list.dto.Music;

import java.util.List;
import java.util.Scanner;

// 화면을 담당하는 클래스 (출력문, 입력문)
public class MusicView {

    private MusicController mc = new MusicController();
    private Scanner sc = new Scanner(System.in);

    // 메인화면
    public void mainMenu(){

        while(true){
            System.out.println("\n=== 음악 관리 프로그램 ===");
            System.out.println("1. 신규 곡 추가");
            System.out.println("2. 곡 전체 조회");
            System.out.println("3. 특정 곡 삭제");
            System.out.println("4. 특정 곡 수정"); // 수정할곡명, 수정곡명, 수정가수명 입력받은 후 요청
            System.out.println("5. 특정 곡 검색");
            System.out.println("6. 특정 가수명 입력");
            System.out.println("7. 특정 가수 곡의 개수");
            System.out.println("0. 프로그램 종료");
            System.out.print(">> 메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu){
                case 1: inputMusic();  break;
                case 2: selectMusic(); break;
                case 3: removeMusic(); break;
                case 4: modifyMusic(); break;
                case 5: searchMusic(); break;
                case 6: searchArtistToMusicTitle(); break;
                case 7: searchArtistToMusicTitleCount(); break;
                case 0:
                    System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해주세요.");
            }
        }

    }

    // 새로운 곡 추가하는 서브 화면
    public void inputMusic(){
        System.out.println("\n== 신규 곡 추가 ==");
        System.out.print("제목 입력: ");
        String title = sc.nextLine();
        System.out.print("가수 입력: ");
        String artist = sc.nextLine();

        // 사용자가 입력한 곡명, 가수명을 넘기면서 "곡 추가 요청"보내기
        // => Controller 측 메소드 호출
        boolean result = mc.insertMusic(title, artist);
        if(result) {
            System.out.println("성공적으로 곡이 추가되었습니다.");
        }else{
            System.out.println("곡 추가에 실패하였습니다.");
        }

    }

    // 전체 곡 조회용 서브화면
    public void selectMusic(){
        System.out.println("\n== 전체 곡 리스트 ==");

        // 전체 곡 조회 요청 => Controller 메소드 호출
        List<Music> list = mc.selectMusicList();

        if(list.isEmpty()){ // 비어있을 경우
            System.out.println("현재 존재하는 곡이 없습니다.");
        }else{ // 비어있지 않을 경우
            for(Music m : list){
                System.out.println(m);
            }
        }

    }

    // 특정 곡 삭제 서브화면
    public void removeMusic(){
        System.out.println("\n== 특정 곡 삭제 ==");

        System.out.print("삭제하고자 하는 곡명: ");
        String title = sc.nextLine();

        // 삭제 요청 보내기
        int result = mc.deleteMusic(title);

        if(result > 0){
            System.out.println("성공적으로 삭제되었습니다.");
        }else{
            System.out.println("삭제할 곡을 찾지 못했습니다.");
        }

    }

    public void modifyMusic(){
        System.out.println("\n== 특정 곡 수정 ==");
        System.out.print("수정하고자 하는 곡명: ");
        String title = sc.nextLine();
        System.out.print("수정 내용(곡명): ");
        String upTitle = sc.next();
        System.out.print("수정 내용(가수명): ");
        String upArtist = sc.nextLine();

        int result = mc.updateMusic(title,upTitle,upArtist);

        if(result > 0){
            System.out.println("성공적으로 수정되었습니다.");
        }else{
            System.out.println("수정할 곡을 찾지 못했습니다.");
        }
    }

    public void searchMusic(){
        System.out.println("\n== 특정 곡 검색 ==");

        System.out.println("검색할 곡명(키워드도 가능): ");
        String keyword = sc.nextLine();

        List<Music> searchList = mc.searchMusicByKeyword(keyword);
        if(searchList.isEmpty()){
            System.out.println("검색된 결과가 없습니다.");
        }else{
            for(Music m : searchList){
                System.out.println(m);
            }
        }
    }

    public void searchArtistToMusicTitle(){
        System.out.println("\n== 특정 가수명 검색 ==");
        System.out.print("검색할 가수명: ");
        String artist = sc.nextLine();
        List<String> title = mc.searchArtistToMusicTitle(artist);
        if(title.isEmpty()){
            System.out.println("찾으시는 가수명이 존재하지않습니다.");
        }else{
            for(int i = 0; i<title.size(); i++){
                System.out.println(title.get(i));
            }
        }
    }

    public void searchArtistToMusicTitleCount(){
        System.out.println("\n== 특정 가수명 검색 ==");
        System.out.print("검색할 가수명: ");
        String artist = sc.nextLine();
        int count = mc.searchArtistToMusicTitleCount(artist);
        if(count == 0){
            System.out.println("찾으시는 가수명이 존재하지않습니다.");
        }else{
            System.out.println("찾으시는 가수의 곡수는 " + count + "개입니다.");
        }
    }
}