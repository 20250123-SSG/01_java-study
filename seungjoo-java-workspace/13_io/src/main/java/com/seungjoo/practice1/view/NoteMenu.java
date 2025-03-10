package com.seungjoo.practice1.view;

import com.seungjoo.practice1.dao.FileDao;

import java.util.Scanner;

public class NoteMenu {
    Scanner sc = new Scanner(System.in); // 사용자에게 입력을 받기 위한 객체
    FileDao fdao = new FileDao(); //


    public void mainMenu() {
        while (true) {
            System.out.println("===== MyNote =====");
            System.out.println("1. 노트 새로 만들기");
            System.out.println("2. 노트 열기");
            System.out.println("3.노트 열어서 수정하기");
            System.out.println("4.끝내기");
            System.out.println("번호를 입력하세요 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                createNote();
            } else if (choice == 2) {
                openNote();
            } else if (choice == 3) {
                editNote();
            } else if (choice == 4) {
                return;
            }
        }


    }


    public void createNote() {
        while (true) {
            System.out.println("파일에 저장할 내용을 입력하시오");
            String str = sc.nextLine();
            if (str.equals("exit")) {
                System.out.println("내용 입력 끝");
                break;
            }
            System.out.println("저장하시겠습니까? (y/n) : ");
            String choice = sc.nextLine();
            if (choice.equals("y") || choice.equals("Y")) {
                String name = sc.nextLine();
                fdao.fileSave(str, name);
                System.out.println(name + "txt 파일에 성공적으로 저장하였습니다.");
            } else if (choice.equals("n") || choice.equals("N")) {
                System.out.println("다시 메뉴로 돌아갑니다.");
                return;
            }

        }
    }
        public void openNote() {
            String str = sc.nextLine();
            String result = fdao.fileOpen(str);
            if (result == null) {
                System.out.println("존재하는 파일이 없습니다.");
            } else {
                System.out.println(result);
            }
        }

        public void editNote() {
        String str = sc.nextLine();
        String content = fdao.fileOpen(str);
        if (content == null) {
            System.out.println("존재하는 파일이 없습니다.");
        }else{
            String sum = content;
            while(true){
                String str1 = sc.nextLine();

                if(str1 == "exit"){
                    System.out.println("변경된 내용을 파일에 추가하시겠습니까? (y/n) :");
                    if (str1.equals("y") || str1.equals("Y")) {
                        fdao.fileSave(sum,str);
                        System.out.println(str+"txt 파일의 내용이 변경되었습니다.");
                    }
                    break;
                }
                sum += str1 + "\n";

            }

        }


        }


    }

