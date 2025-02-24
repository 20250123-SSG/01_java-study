package com.ino.section02.list.view;

import com.ino.section02.list.controller.MusicController;
import com.ino.section02.list.dto.Music;

import java.util.List;
import java.util.Scanner;

public class MusicView {

    private MusicController mc = new MusicController();
    private Scanner sc = new Scanner(System.in);
    public void removeMusic(){
        System.out.println("\n== 특정 곡 삭제");
        System.out.println("삭제 곡 명");
        String title = sc.nextLine();

        mc.deleteMusic(title);
    }
    public void mainMenu() {
        while (true) {
            System.out.println("\n musinc control program");
            System.out.println("1. add new music");
            System.out.println("2. search all music");
            System.out.println("3. delete specify music");
            System.out.println("4. edit spec music");
            System.out.println("5. search spec music");
            System.out.println("0. exit program");
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    String name = sc.nextLine();
                    String artist = sc.nextLine();
                    if (mc.insertMusic(name, artist)) {
                        System.out.println("added successfully");
                    }
                    else {
                        System.out.println("error occurred");
                    }
                    break;
                case 2:
                    List<Music> mList = mc.selectMusic();
                    break;
                case 3:
                    removeMusic();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    break;
            }
        }
    }


}
