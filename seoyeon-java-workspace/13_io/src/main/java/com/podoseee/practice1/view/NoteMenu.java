package com.podoseee.practice1.view;

import com.podoseee.practice1.dao.FileDao;

import java.util.Scanner;

public class NoteMenu {
    Scanner sc = new Scanner(System.in); // 사용자에게 입력을 받기 위한 객체
    FileDao fdao = new FileDao(); // FileDao클래스의 메소드 호출을 위한 객체
    StringBuilder content = new StringBuilder();

    public void mainMenu() {
        // 반복문을 통한 메뉴 실행
        while(true) {
            System.out.println("====== MyNote ======");
            System.out.println("1. 노트 새로 만들기");
            System.out.println("2. 노트 열기");
            System.out.println("3. 노트 열어서 수정하기");
            System.out.println("4. 끝내기");
            System.out.print("번호를 입력하세요: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: createNote(); break;
                case 2: openNote(); break;
                case 3: editNote(); break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("다시 입력하세요.");
            }
        }
    }

    public void createNote() {
        System.out.print("파일에 저장할 내용을 입력하시오 (exit을 입력하면 내용입력 끝)");
        // “파일에 저장할 내용을 입력하시오 (exit을 입력하면 내용입력 끝)” 출력
        // 사용자에게 파일에 저장하고자 하는 여러 줄의 내용을 반복적으로 입력 받아
        // String으로 기록하기
        //  이때 사용자가 입력한 문자열이 exit일 경우 더 이상 입력되지 않도록 하기
        while (true){
            String input = sc.nextLine();
            if (input.equals("exit")){
                break;
            }
            content.append(input).append("\n");
        }

        // “저장하시겠습니까? (y/n) : “ 출력 후
        System.out.print("저장하시겠습니까? (y/n) : ");
        String choice = sc.nextLine();
        // 대소문자 상관없이 y일 경우 저장시킬 파일명(확장자 제외하고)을 입력받아
        if(choice.equalsIgnoreCase("y")){
            System.out.print("저장할 파일명을 입력하세요 (확장자 제외) : ");
            String fileName = sc.nextLine();
        // FileDao의 fileSave 메소드로 사용자가 입력한 파일내용과 파일명을 전달하면서 호출
            FileDao fileDao = new FileDao();
            fileDao.fileSave(content.toString(), fileName);
        // “xxx.txt 파일에 성공적으로 저장하였습니다.” 출력
            System.out.println(fileName + ".txt 파일에 성공적으로 저장하였습니다.");
        }else{// n일 경우 “다시 메뉴로 돌아갑니다.” 출력
            System.out.println("다시 메뉴로 돌아갑니다.");
        }

    }

    public void openNote() {
        // 사용자에게 열고자 하는 파일명을 입력받아 (확장자 제외하고)
        System.out.print("열고자 하는 파일명을 입력하시오");
        String fileName = sc.nextLine();
        // FileDao 클래스의 fileOpen 메소드 호출시 전달하여
        String fileContent = fdao.fileOpen(fileName);
        // 결과 돌려받아 출력하기
        // 단, 존재하는 파일이 아니였을 경우 “존재하는 파일이 없습니다.” 출력
        if(fileContent == null){
            System.out.println("존재하는 파일이 없습니다.");
        } else {
            System.out.println("파일 내용: ");
            System.out.println(fileContent);
        }
    }

    public void editNote() {
        // 수정할 파일명(확장자 제외) 입력받아
        System.out.print("수정할 파일명을 입력하시오 : ");
        String fileName = sc.nextLine();
        // FileDao 클래스의 fileOpen 메소드 호출하여 해당 파일 안의 내용 돌려받기
        String fileContent = fdao.fileOpen(fileName);
        // 단, 존재하는 파일이 아니였을 경우 “존재하는 파일이 없습니다.” 출력
        // 존재하는 파일이 맞다면 createNote메소드에서와 비슷하게
        if(fileContent == null){
            System.out.println("존재하는 파일이 없습니다.");
            return;
        }

        System.out.println("현재 파일 내용 : ");
        System.out.println(fileContent);

        // 사용자에게 반복적으로 추가시키고자 하는 내용을 입력 받아
        StringBuilder newContent = new StringBuilder(fileContent);
        System.out.println("추가할 내용을 입력하시오 (exit을 입력하면 수정 끝)");
        while(true){
        String fileAdd = sc.nextLine();

        // 기존의 파일 내용과 여러줄로 합치기
        //내가 쓴 잘못된 코드 System.out.print(fileContent + fileAdd);
        // exit을 입력했을 경우 더 이상 입력되지 않도록 하고
        if(fileAdd.equalsIgnoreCase("exit")){
            break;
        } else{
            newContent.append(fileAdd).append("\n");

        }
            // “변경된 내용을 파일에 추가하시겠습니까? (y/n) : “ 출력하여
        System.out.print("변경된 내용을 파일에 추가하시겠습니까? (y/n) : ");
        String choice = sc.nextLine();

        // y일 경우 변경된 파일내용과 파일명을 다시
        // FileDao클래스의 fileSave메소드 호출시 전달하여 저장시키기
        if(choice.equalsIgnoreCase("y")){
            fdao.fileSave(newContent.toString(), fileName);
        // “xxx.txt 파일의 내용이 변경되었습니다.” 출력
            System.out.println(fileName + ".txt 파일의 내용이 변경되었습니다.");
        } else{
            System.out.println("수정 취소");
        }
    }
    }
}
