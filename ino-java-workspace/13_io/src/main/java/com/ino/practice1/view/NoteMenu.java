package com.ino.practice1.view;

import com.ino.practice1.dao.FileDao;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoteMenu {
    Scanner sc = new Scanner(System.in);
    FileDao fdao = new FileDao();

    public void mainMenu(){
        while(true) {
            System.out.print("""
                    ====== MyNote ======
                    1. 노트 새로 만들기
                    2. 노트 열기
                    3. 노트 열어서 수정하기
                    4. 끝내기
                    번호를 입력하세요 : """);
            int menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1: createNote(); break;
                case 2: openNote(); break;
                case 3: editNote(); break;
                case 4: return;
            }
        }
    }

    public void createNote(){
        String str = null;
        StringBuilder sb = new StringBuilder();
        while(true){
            System.out.print("파일에 저장할 내용을 입력하시오 (exit을 입력하면 내용입력 끝) : ");
            str = sc.nextLine();
            if(str.equals("exit")) {
                break;
            }
            else {
                sb.append(str);
            }
        }
        System.out.print("저장하시겠습니까? (y/n) : ");
        if(sc.nextLine().charAt(0) == 'y' || sc.nextLine().charAt(0) == 'Y') {
            System.out.print("파일명(확장자 제외하고) : ");
            String fileName = sc.nextLine();
            fdao.fileSave(sb.toString(), fileName);
        } else {
            System.out.print("다시 메뉴로 돌아갑니다.");
        }

    }

    public void openNote(){
        System.out.print("사용자에게 열고자 하는 파일명을 입력받아 (확장자 제외하고)");
        String fileName = sc.nextLine();
        try {
            System.out.println(fdao.fileOpen(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("존재하는 파일이 없습니다.");
        }
    }

    public void editNote(){
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        System.out.print("수정할 파일명(확장자 제외) 입력");
        String title = sc.nextLine();
        try {
            sb.append(fdao.fileOpen(title));
        } catch (FileNotFoundException e) {
            System.out.println("존재하는 파일이 없습니다.");
            return;
        }
        while(true) {
            System.out.print("추가시키고자 하는 내용: ");
            String content = sc.nextLine();
            if (!content.equals("exit")){
                sb2.append(content);
            }
            else {
                break;
            }
        }
        System.out.print("변경된 내용을 파일에 추가하시겠습니까? (y/n) : ");
        if (sc.nextLine().charAt(0) == 'y' || sc.nextLine().charAt(0) == 'Y') {
            fdao.fileSave(sb.append(sb2.toString()).toString(), title);
            System.out.println(title + ".txt 파일의 내용이 변경되었습니다.");
        }
    }
}
