package section02.list.view;

import section02.list.controller.MusicController;
import section02.list.dto.Music;

import java.util.List;
import java.util.Scanner;

public class MusicView {
    private MusicController musicController = new MusicController();
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu(){

        while (true){
            System.out.println("====음악관리프로그램====");
            System.out.println("1. 신규 곡 추가");
            System.out.println("2. 곡 전체 조회");
            System.out.println("3. 특정 곡 삭제");
            System.out.println("4. 특정 곡 수정");
            System.out.println("5. 특정 곡 검색");
            System.out.println("0. 종료");
            int menuNum = scanner.nextInt();
            scanner.nextLine();

            switch (menuNum){
                case 1: inputMusic(); break;
                case 2:selectMusic(); break;
                case 3: removeMusic(); break;
                case 4: break;
                case 5: break;
                case 0: return;
                default:
                    System.out.println("메뉴 잘못 선택, 다시 선택");
            }
        }
    }

    private void inputMusic() {
        System.out.println("신규 곡 추가");
        System.out.println("제목 입력 : ");
        String title = scanner.nextLine();
        System.out.println("가수 입력 : ");
        String artist = scanner.nextLine();

        boolean isInsert = musicController.insertMusic(title, artist);
        if(isInsert){
            System.out.println("성공적으로 곡이 추가되었습니다.");
        }else {
            System.out.println("곡 추가에 실패");
        }
    }

    public void selectMusic (){
        System.out.println("전체 곡 리스트 출력");
        List<Music> result = musicController.selectMusicList();

        if(result.isEmpty()){
            System.out.println("비어있어요");
            return;
        }

        for(Music music : result){
            System.out.println(music);
        }
    }

    public void removeMusic (){
        System.out.println("===곡 삭제===");
        System.out.println("삭제 곡 이름");
        String title = scanner.nextLine();


        if(musicController.removeMusic(title) > 0){
            System.out.println("삭제되었습니다.");
        }else {
            System.out.println("존재하지 않는 음악입니다.");
        }
    }

    public void editMusic (){
        System.out.println("수정 곡 이름");
        String title = scanner.nextLine();
        System.out.println("수정 가수명");
        String artist = scanner.nextLine();
        System.out.println("수정어떻게할건지");
        String editTitle = scanner.nextLine();

        if(musicController.editMusic(title, artist, editTitle) > 0){
            System.out.println("수정되었습니다.");
        }else{
            System.out.println("존재하지 않는 음악입니다.");
        }


    }
}
