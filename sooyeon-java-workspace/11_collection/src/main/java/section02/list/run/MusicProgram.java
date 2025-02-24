package section02.list.run;

import section02.list.view.MusicView;

public class MusicProgram {
    public static void main(String[] args) {
        /**
         * ## MVC 패턴
         * 유지보수를 위해 클래스에 역할을 부여하고 분리함
         *
         * - M(Model) : 데이터를 담당
         *              ㄴ 데이터를 담기 위한 클래스 DTO
         *              ㄴ 비지니스 로직을 처리하기 위한 클래스 Service
         *              ㄴ 데이터가 보관되어있는 보관함과 연결해서 입출력 하는 클래스 dao
         *
         * - V(View) : 화면을 담당
         *              ㄴ 시각적인 요소
         *              ㄴ입출력
         *
         * - C(Controller) : 요청처리를 담당하는 클래스 view와 model의 징검다리
         *
         */

        new MusicView().mainMenu();
    }
}
