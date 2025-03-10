package com.kyungbae.practice4.view;

import com.kyungbae.practice4.controller.EmployeeManager;
import com.kyungbae.practice4.dto.Employee;

import java.util.Scanner;

public class EmpMenu {
    Scanner sc = new Scanner(System.in);
    EmployeeManager em = new EmployeeManager();


    public void mainMenu(){
        while (true) {
            System.out.println("\n===== 사원 정보 관리 프로그램 =====");
            System.out.println("1. 새 사원 정보 입력");
            System.out.println("2. 사원 정보 수정");
            System.out.println("3. 사원 정보 삭제");
            System.out.println("4. 사원 정보 출력");
            System.out.println("0. 프로그램 종료");
            System.out.print(">> 메뉴 번호 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu){
                case 1 : inputEmployee(); break;
                case 2 : modifyEmployee(); break;
                case 3 : deleteEmployee(); break;
                case 4 : outputEmployee(); break;
                case 0 :  return;
                default:
                    System.out.println("다시 입력해주세요.");
            }


        }

    }

    public void inputEmployee(){
        System.out.println("\n=== 사원 정보 입력 ===");
        System.out.print("사원명: ");
        String name = sc.nextLine();
        System.out.print("부서명: ");
        String dept = sc.nextLine();
        System.out.print("직급: ");
        String job = sc.nextLine();
        System.out.print("나이: ");
        String age = sc.nextLine();
        System.out.print("성별: ");
        String gender = sc.nextLine();
        System.out.print("급여: ");
        String salary = sc.nextLine();
        System.out.print("보너스포인트: ");
        String bonusPoint = sc.nextLine();
        System.out.print("전화번호: ");
        String phone = sc.nextLine();
        System.out.print("주소: ");
        String address = sc.nextLine();

        if(em.inputEmployee(name, dept, job, age, gender, salary, bonusPoint, phone, address)){
            System.out.println("성공적으로 추가되었습니다.");
        } else {
            System.out.println("추가에 실패하였습니다. 확인 바랍니다.");
        }
    }

    public void modifyEmployee(){
        while (true) {
            System.out.println("\n=== 사원 정보 수정 메뉴 ===");
            System.out.println("1. 이름 변경");
            System.out.println("2. 급여 변경");
            System.out.println("3. 부서 변경");
            System.out.println("4. 직급 변경");
            System.out.println("0. 이전 메뉴로");
            System.out.print(">> 메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu){
                case 1:
                    System.out.print("이름 입력: ");
                    String name = sc.nextLine();
                    if(em.modifyName(name)){
                        System.out.println("이름이 변경되었습니다.");
                    };
                    break;
                case 2:
                    System.out.print("급여 입력: ");
                    String salary = sc.nextLine();
                    if(em.modifySalary(salary)){
                        System.out.println("급여가 변경되었습니다.");
                    }
                    break;
                case 3:
                    System.out.print("부서 입력: ");
                    String dept = sc.nextLine();
                    if (em.modifyDept(dept)){
                        System.out.println("부서가 변경되었습니다.");
                    }
                    break;
                case 4:
                    System.out.print("직급 입력: ");
                    String job = sc.nextLine();
                    if (em.modifyJob(job)){
                        System.out.println("직급이 변경되었습니다.");
                    }
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }


    }

    public void deleteEmployee(){

        while (true) {
            System.out.println("\n=== 사원 정보 삭제 ===");
            System.out.print("정말 삭제하시겠습니까? (y/n) : ");
            char c = sc.nextLine().charAt(0);
            if (c == 'y' || c == 'Y') {
                if(em.deleteEmployee()) {
                    System.out.println("삭제되었습니다.");
                }
                break;
            } else if (c == 'n' || c == 'N') {
                System.out.println("메뉴로 돌아갑니다.");
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력부탁드립니다.");
            }
        }

    }

    public void outputEmployee(){
        System.out.println("\n=== 사원 정보 출력 ===");
        System.out.println(em.outputEmployee());
    }

}
