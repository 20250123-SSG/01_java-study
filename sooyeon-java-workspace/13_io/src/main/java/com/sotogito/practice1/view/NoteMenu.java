package com.sotogito.practice1.view;

import com.sotogito.practice1.dao.FileDao;

import java.util.Scanner;

public class NoteMenu {
    Scanner sc = new Scanner(System.in);
    FileDao fdao = new FileDao();

    public void mainMenu() {
        while (true) {
            System.out.println("""
                    ====== MyNote ======
                    1. 노트 새로 만들기
                    2. 노트 열기
                    3. 노트 열어서 수정하기
                    4. 끝내기
                    번호를 입력하세요 :
                    """);
            int functionOption = sc.nextInt();
            sc.nextLine();

            switch (functionOption) {
                case 1: createNote();break;
                case 2: openNote();break;
                case 3: editNote();break;
                case 4:
                    return;
            }
        }
    }

    public void createNote() {
        System.out.println("파일에 저장할 내용을 입력하시오 (exit을 입력하면 내용입력 끝)");
        String content = inputContents();

        System.out.println("저장하시겠습니까?(y/n)");
        if (!sc.nextLine().equalsIgnoreCase("y")) {
            System.out.println("메뉴로 돌아갑니다.");
            return;
        }

        System.out.println("저장할 파일명을 입력해주세요.");
        String fileName = sc.nextLine().trim();
        if (fileName.isEmpty()) {
            return;
        }

        fdao.fileSave(content.toString(), fileName);
        System.out.printf("%s.txt 파일에 성공적으로 저장하였습니다.\n", fileName);
    }

    public void openNote() {
        System.out.println("열람하고자 하는 파일명을 입력하세요.");
        String contents = fdao.fileOpen(sc.nextLine().trim());
        if (contents == null) {
            System.out.println("존재하지 않는 파일명이에요");
            return;
        }
        System.out.print(contents);
    }

    public void editNote() {
        System.out.println("수정하고자하는 파일명을 입력해주세요.");
        String fileName = sc.nextLine().trim();

        String existingContents = fdao.fileOpen(fileName);
        if (existingContents == null) {
            System.out.println("존재하지 않는 파일명이에요");
            return;
        }

        System.out.print(existingContents);
        String newContents = inputContents();

        fdao.fileSave((existingContents + newContents), fileName);
        System.out.printf("%s.txt 파일의 내용이 변경되었습니다.\n", fileName);
    }


    private String inputContents() {
        StringBuilder result = new StringBuilder();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("exit")) {
                result.delete(result.length() - 1, result.length()); //마지막줄바꿈삭제
                break;
            }
            result.append(input).append("\n");
        }
        return result.toString();
    }

}
