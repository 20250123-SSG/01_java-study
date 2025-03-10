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
            System.out.println("5. 특정 곡명 검색");
            System.out.println("6. 가수명으로 곡명 검색");
            System.out.println("7. 특정 곡 개수 조회");
            System.out.println("8. 곡 정렬 조회");
            System.out.println("0. 프로그램 종료");
            System.out.print(">> 메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu){
                case 1: inputMusic(); break;
                case 2: selecMusic(); break;
                case 3: removeMusic(); break;
                case 4: modifyMusic(); break;
                case 5: searchMusic(); break;
                case 6: searchArtist(); break;
                case 7: countMusic(); break;
                case 8: sortMusic(); break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴를 잘못 선택하셨습니다. 다시 선택해주세요.");
            }


        }
    } // main end

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

    } // inputMusic end

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

    } // selectMusic end

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

    } // removeMusic end

    // 곡을 수정하는 메소드
    public void modifyMusic(){

        System.out.println("\n==특정 곡 수정==");
        System.out.print("수정할 곡명 입력 : ");
        String title = sc.nextLine();
        System.out.print("수정 내용(곡명) : ");
        String upTitle = sc.nextLine();
        System.out.print("수정 내용(가수명) : ");
        String upArtist = sc.nextLine();

        if (mc.updateMusic(title, upTitle, upArtist) > 0) {
            System.out.println("수정을 완료하였습니다.");
        } else {
            System.out.println("해당 곡을 찾지 못했습니다.");
        }

    } // modifyMusic end

    // 곡을 검색하는 메소드
    public void searchMusic() {

        System.out.println("\n==특정 곡명 검색==");
        System.out.print("검색할 곡명 입력 : ");
        String keyword = sc.nextLine();

        List<Music> result = mc.searchMusicByKeyword(keyword);
        if (result.isEmpty()) {
            System.out.println("해당 곡을 찾을 수 없습니다.");
        } else {
            for(Music list : result){
                System.out.println(list);
            }
        }
    } // searchMusic end

    // 가수명으로 곡 제목을 검색하는 메소드
    public void searchArtist(){

        System.out.println("\n==가수명으로 곡명 검색==");
        System.out.print("검색할 가수명 입력 : ");
        String artist = sc.nextLine();

        List<String> result = mc.searchArtist(artist);
        if (result.isEmpty()) {
            System.out.println("해당 가수명을 찾을 수 없습니다.");
        } else {
            for(String list : result){
                System.out.println(list);
            }
        }
    }// searchArtist end

    // 특정 곡 개수 조회
    public void countMusic(){
        System.out.println("\n==특정 곡 개수 검색==");
        System.out.print("개수를 조회할 곡명 입력 : ");
        String keyword = sc.nextLine();

        List<Music> result = mc.searchMusicByKeyword(keyword);
        if (result.isEmpty()) {
            System.out.println("해당 곡을 찾을 수 없습니다.");
        } else {
            System.out.println("해당 키워드를 가진 곡은 " + mc.countMusic(result) + "개 있습니다.");
        }

    }// countMusic end

    // 곡 정렬 조회
    public void sortMusic(){
        System.out.println("\n== 곡 정렬 조회 ==");
        System.out.println("1. 가수명 오름차순");
        System.out.println("2. 가수명 내림차순");
        System.out.println("3. 곡명 오름차순");
        System.out.println("4. 곡명 내림차순");
        System.out.print(">> 메뉴 선택 : ");
        int menu = sc.nextInt();
        sc.nextLine();

        List<Music> list = mc.sortMusic(menu);

        for(Music m : list){
            System.out.println(m);
        }

    }

} // end class
