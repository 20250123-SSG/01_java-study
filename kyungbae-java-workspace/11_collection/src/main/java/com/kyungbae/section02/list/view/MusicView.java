package com.kyungbae.section02.list.view;

import com.kyungbae.section02.list.controller.MusicController;
import com.kyungbae.section02.list.dto.Music;

import java.util.List;
import java.util.Scanner;

// 화면을 담당하는 클래스 (출력문, 입력문)
public class MusicView {

    private MusicController mc = new MusicController();
    private Scanner sc = new Scanner(System.in);

    // 메인화면
    public void mainMenu(){

        while (true){
            System.out.println("\n=== 음악 관리 프로그램 ===");
            System.out.println("1. 신규 곡 추가");
            System.out.println("2. 곡 전체 조회");
            System.out.println("3. 특정 곡 삭제");
            System.out.println("4. 특정 곡 수정"); // 수정할 곡명, 수정곡명, 수정가수명 입력받은 후 요청
            System.out.println("5. 특정 곡 검색");
            System.out.println("0. 프로그램 종료");
            System.out.print(">> 메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu){
                case 1: inputMusic(); break;
                case 2: selecMusic(); break;
                case 3: removeMusic(); break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해주세요.");
            }


        }
    }

    // 새로운 곡 추가하는 서브 화면
    public void inputMusic(){
        System.out.println("\n==신규 곡 추가==");
        System.out.print("제목 입력 : ");
        String title = sc.nextLine();
        System.out.print("가수 입력 : ");
        String artist = sc.nextLine();

        // 사용자가 입력한 곡명, 가수명을 넘기면서 곡추가 요청보내기
        // => Controller 측 메소드 호출
        if (mc.insertMusic(title, artist)) {
            System.out.println("새로운 곡을 추가하였습니다.");
        } else {
            System.out.println("실패!");
        }

    }

    // 전체 곡 조회용 서브화면
    public void selecMusic(){
        System.out.println("\n===전체 곡 리스트===");

        // 전체 곡 조회 요청
        List<Music> list = mc.selectMusicList();
        if (list.isEmpty()) {
            System.out.println("곡이 없습니다.");
        } else {
            for (Music m : list) {
                System.out.println(m);
            }
//            for (int i = 0; i < mc.selectMusicList().size(); i++) {
//                System.out.println(mc.selectMusicList().get(i).toString());
//            }
        }

    }

    // 곡을 삭제하는 메소드
    public void removeMusic(){
        System.out.println("\n==특정 곡 삭제==");

        System.out.print("삭제할 곡명 입력 : ");
        String title = sc.nextLine();
        int delete = mc.deleteMusic(title);
        if (delete > 0) {
            System.out.println(title + " 곡을 삭제하였습니다.");
        } else {
            System.out.println("해당 곡을 찾지 못했습니다.");
        }

    }

}
