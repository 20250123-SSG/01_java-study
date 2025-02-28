package com.kyungbae.practice1.view;

import com.kyungbae.practice1.dao.FileDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteMenu {
    Scanner sc = new Scanner(System.in);
    FileDao fdao = new FileDao();

    public void mainMenu(){

        while (true){
            System.out.println("\n==== MyNote ====");
            System.out.println("1. 노트 새로 만들기");
            System.out.println("2. 노트 열기");
            System.out.println("3. 노트 열어서 수정하기");
            System.out.println("4. 끝내기");
            System.out.print(">> 번호 입력: ");
            String a = sc.nextLine();
            int menu = Integer.parseInt(a);

            switch (menu){
                case 1 : createNote(); break;
                case 2 : openNote(); break;
                case 3 : editNote(); break;
                case 4 :
                    System.out.println("프로그램을 종료합니다."); return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void createNote(){
        List<String> list = new ArrayList<>();
        System.out.println("파일에 저장할 내용을 입력하시오.");
        int i = 0;
        while (true){
            System.out.print("> ");
            String a = sc.nextLine();
            list.add(a);
            if(list.get(i).equals("exit")){
                list.remove(i);
                break;
            }
            i++;
        }

        while (true) {
            System.out.print("저장하시겠습니까? (y/n): ");
            char c = sc.nextLine().charAt(0);
            if(c == 'y' || c == 'Y'){
                StringBuilder sb = new StringBuilder();
                for (String s : list) {
                    sb.append(s).append('\n');
                }
                System.out.print("파일명 입력(확장자 제외): ");
                String fileName = sc.nextLine();
                fdao.fileSave(sb.toString(), fileName);
                System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
                break;
            } else if (c == 'n' || c == 'N') {
                System.out.println("다시 메뉴로 돌아갑니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void openNote(){
        System.out.println("\n=== 노트열기 ===");
        System.out.print("열기 할 파일명: ");
        String fileName = sc.nextLine();
        String str = fdao.fileOpen(fileName);
        if(str == null){
            System.out.println("존재하는 파일이 없습니다.");
        } else {
            System.out.println(str);
        }
    }

    public void editNote(){
        System.out.print("수정할 파일명 입력: ");
        String fileName = sc.nextLine();
        String str = fdao.fileOpen(fileName);
        if(str == null){
            System.out.println("존재하는 파일이 없습니다.");
        } else {
            System.out.println(str);
        }
        List<String> list = new ArrayList<>();
        list.add(str);
        int i = 1;
        while (true){
            System.out.print("> ");
            list.add(sc.nextLine());
            if(list.get(i).equals("exit")){
                list.remove(i);
                break;
            }
            i++;
        }
        while (true) {
            System.out.print("변경된 내용을 파일에 추가하시겠습니까? (y/n): ");
            char c = sc.nextLine().charAt(0);
            if(c == 'y' || c == 'Y'){
                StringBuilder sb = new StringBuilder();
                for (String s : list) {
                    sb.append(s).append('\n');
                }
                fdao.fileSave(sb.toString(), fileName);
                System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
                break;
            } else if (c == 'n' || c == 'N') {
                System.out.println("다시 메뉴로 돌아갑니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
