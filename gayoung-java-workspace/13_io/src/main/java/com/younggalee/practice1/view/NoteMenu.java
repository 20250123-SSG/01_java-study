package com.younggalee.practice1.view;

import com.younggalee.practice1.dao.FileDao;

import java.util.Scanner;

public class NoteMenu {
    Scanner sc = new Scanner(System.in);
    FileDao fdao = new FileDao();

    public void mainMenu() {
        while(true){
            System.out.print("====== MyNote ======\n" +
                    "1. 노트 새로 만들기\n" +
                    "2. 노트 열기\n" +
                    "3. 노트 열어서 수정하기\n" +
                    "4. 끝내기\n" +
                    "번호를 입력하세요 : ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 4){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch(menu){
                case 1: createNote(); break;
                case 2: openNote(); break;
                case 3: editNote(); break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void createNote() {
        System.out.println("파일에 저장할 내용을 입력하시오 (exit을 입력하면 내용입력 끝)");
        StringBuilder contents = new StringBuilder();
        while(true){

            String inputLine = sc.nextLine();

            if (inputLine.equals("exit")){
                System.out.println("저장하시겠습니까? (y/n) : ");
                char save = sc.nextLine().charAt(0);
                if (save == 'y' || save == 'Y'){
                    System.out.println("저장할 파일명을 입력하시오 : ");
                    String fileName = sc.nextLine();
                    fdao.fileSave(String.valueOf(contents),fileName + ".txt");
                    System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
                } else{
                    System.out.println("다시 메뉴로 돌아갑니다.");
                }
                break;
            }
            contents.append(inputLine).append("\n");
        }
    }

    public void openNote() {
        System.out.print("열기 할 파일명 : ");
        String fileName = sc.nextLine();
        String result = fdao.fileOpen(fileName);
        if (result == null){
            System.out.println("존재하는 파일이 없습니다.");
        } else {
            System.out.println(result);
        }
    }

    public void editNote() {
        System.out.print("수정할 파일명 : ");
        String fileName = sc.nextLine();
        String contents = fdao.fileOpen(fileName);

        if (contents == null){
            System.out.println("존재하는 파일이 없습니다.");
        } else {
            System.out.println("* 파일에 추가할 내용을 입력하시오.(\"exit\"을 입력하면 내용 입력 끝) *");
            while(true){
                String inputLine = sc.nextLine();

                if (inputLine.equals("exit")) {
                    System.out.println("저장하시겠습니까? (y/n) : ");
                    char save = sc.nextLine().charAt(0);
                    if (save == 'y' || save == 'Y') {
                        fdao.fileSave(contents, fileName + ".txt");
                        System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
                        break;
                    }
                }
                contents = contents + inputLine + "\n";
            }
        }
    }
}

