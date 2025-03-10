package com.minkook.section02.list.run;

import com.minkook.section02.list.view.MusicView;

public class MusicProgram {

    public static void main(String[] args) {

        /*
            ## MVC 패턴 ##
            각 클래스마다 역할(데이터담당, 화면담당, 요청처리담당)을 부여해서 작업
            => 유지보수 용이해짐

            > M (Model) : 데이터를 담당하는 역할의 클래스
                          ㄴ 데이터들을 담기위한 클래스 (dto)
                          ㄴ 비즈니스 로직 처리하기 위한 클래스 (service)
                          ㄴ 데이터가 보관되어있는 보관함과 연결해서 입출력 하는 클래스 (dao)

            > V (View) : 화면을 담당하는 역할의 클래스
                         즉, 사용자에게 보여지는 시각적인 요소
                         출력문(print), 입력문(Scanner)

            > C (Controller) : 사용자가 요청한 내용을 처리한 후 그 결과를 돌려주는 역할의 클래스
         */

        new MusicView().mainMenu();


    }

}
