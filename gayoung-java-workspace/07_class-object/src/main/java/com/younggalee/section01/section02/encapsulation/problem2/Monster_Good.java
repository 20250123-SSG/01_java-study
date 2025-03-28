package com.younggalee.section01.section02.encapsulation.problem2;
// 내부코드라 생각하면 여기서 변수명 등 변경해도 외부 코드 변경할 필요 없어짐()
public class Monster_Good {
    String name;
    int hp;

    public void setHp(int hp){
        if(hp < 0){
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    /*
    ## 문제점 2 해결 ##
    이름 정보를 변경하고 확인하는 용도의 각 메소드를 만들어서
    해당 메소드를 이용할 수 있도록
     */

    public void setName(String name){
        this.name = name;
    }

    //정보를 반환해주는 메소드
    public String getInfo(){
        return "몬스터의 이름은 " + this.name + "이고, 체력은 " + this.hp + "입니다.";
    }

    /*
    필드변경시 동일 클래스에서는 해당 필드를 사용한 곳의 코드를 다 변경해야되지만
    호출하는 측의 외부 클래스의 코드는 변경하지 않아도됨.
     */
}
