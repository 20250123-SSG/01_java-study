package com.seungjoo.section02.list.run;

import com.seungjoo.section02.list.dto.Music;

import java.util.ArrayList;
import java.util.List;

//사용자의 요청 처리해주는 클래스
public class MusicController {
    //초기화 블록
    private List<Music> list = new ArrayList<>();
    {
        list.add(new Music("GoodBye", "박효신"));
        list.add(new Music("술이 달다", "에픽하이"));
        list.add(new Music("밥이 달다", "강보람"));

    }

}
