package section02.list.view;

import section02.list.controller.MusicController;
import section02.list.dto.Music;

import java.util.List;
import java.util.Scanner;

public class MusicView {
    private MusicController musicController = new MusicController();
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu() {

        while (true) {
            System.out.println("====음악관리프로그램====");
            System.out.println("1. 신규 곡 추가");
            System.out.println("2. 곡 전체 조회");
            System.out.println("3. 특정 곡 삭제");
            System.out.println("4. 특정 곡 수정");
            System.out.println("5. 곡 이름으로 특정 곡 검색");
            System.out.println("6. 아티스트로 특정 곡 검색");
            System.out.println("7. 특정 곡 수");
            System.out.println("0. 종료");
            int menuNum = scanner.nextInt();
            scanner.nextLine();

            switch (menuNum) {
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
                    editMusic();
                    break;
                case 5:
                    findMusicByTitle();
                    break;
                case 6:
                    findMusicByArtist();
                    break;
                case 7:
                    findMusicCount();
                    break;
                case 8:
                    sortMusic();
                case 0:
                    return;
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
        if (isInsert) {
            System.out.println("성공적으로 곡이 추가되었습니다.");
        } else {
            System.out.println("곡 추가에 실패");
        }
    }

    public void selectMusic() {
        System.out.println("전체 곡 리스트 출력");
        List<Music> result = musicController.selectMusicList();

        if (result.isEmpty()) {
            System.out.println("비어있어요");
            return;
        }

        for (Music music : result) {
            System.out.println(music);
        }
    }

    public void removeMusic() {
        System.out.println("===곡 삭제===");
        System.out.println("삭제 곡 이름");
        String title = scanner.nextLine();


        if (musicController.removeMusic(title) > 0) {
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("존재하지 않는 음악입니다.");
        }
    }

    public void editMusic() {
        System.out.println("수정 곡 이름");
        String title = scanner.nextLine();
        System.out.println("수정 가수명");
        String artist = scanner.nextLine();
        System.out.println("수정어떻게할건지");
        String editTitle = scanner.nextLine();

        if (musicController.editMusic(title, artist, editTitle) > 0) {
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("존재하지 않는 음악입니다.");
        }
    }

    public void findMusicByTitle() {
        System.out.println("검색할 곡 이름을 입력하세요.");
        String keyword = scanner.nextLine();

        List<Music> musics = musicController.findMusicByTitle(keyword);
        if (musics.isEmpty()) {
            System.out.println("존재히지 않는 이름입니다.");
            return;
        }
        musics.forEach(System.out::println);
    }

    public void findMusicByArtist() {
        System.out.println("검색 가수명 :");
        String keyword = scanner.nextLine();

        List<Music> musics = musicController.findMusicByArtist(keyword);

        if (musics.isEmpty()) {
            System.out.println("존재하지 않는 가수명입니다.");
            return;
        }
        musics.forEach(System.out::println);
    }

    public void findMusicCount() {
        System.out.println("검색할 곡 이름을 입력하세요");
        String keyword = scanner.nextLine();

        int count = musicController.findMusicCount(keyword);
        System.out.println(count + "개");
    }

    private void sortMusic() {
        System.out.println("===곡정렬조회===");
        System.out.println("가수명 오름차순");
        System.out.println("가수명 내림차순");
        System.out.println("곡명 오름차순");
        System.out.println("곡명 내림차순");
        int menuNum = scanner.nextInt();

        List<Music> musics = musicController.sortMusic(menuNum);
        musics.forEach(System.out::println);
        /**
         * 정렬기준에 따른 Comparator객체를 생성하고
         * 그 객체들을 sortMusic의 인수로 넘겨주면 더 좋을 거 같다.
         *      - 확장성, 이렇게하면 정렬 방식이 추가될 때 mc수정할 필요 없음
         * menuNum에 따른 해당 Comparator객체를 찾아주는 커멘트패턴의 클래스도
         */
    }

}
