package com.john.section02.mvc_exam.run;

import com.john.section02.mvc_exam.view.MusicView;

/*
    MVC pattern
    - 각 클래스마다 역할을 부여해서 작업
        - M (Model): 데이터를 담당하는 역할의 클래스
            - 데이터를 담기 위한 클래스(dto)
            - 비즈니스 로직을 처리하기 위한 클래스(service)
            - 데이터가 보관되어있는 DB와 연결해서 입출력을 하는 클래스(dao)
            
        - V (View): 화면을 담당하는 역할의 클래스, 사용자에게 보여지는 시각적인 요소(입/출력) 담당

        - C (Controller): 사용자가 요청한 처리내용을 처리한 이후 결과를 반환하는 클래스
            
 */
public class MusicProgram {
    public static void main(String[] args) {

        new MusicView().mainMenu();
    }
}
