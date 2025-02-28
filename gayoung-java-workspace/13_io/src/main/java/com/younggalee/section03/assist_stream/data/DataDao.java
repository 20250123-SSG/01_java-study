package com.younggalee.section03.assist_stream.data;

import java.io.*;

public class DataDao {

    /*
    ## DataOutputStream / DataInputStream ##
    1. 데이터 타입 입출력 보조 스트림
    2. 데이터 자료형 별로 처리하는 기능이 추가되었음
     */

    public void fileSave(){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))) {
            dos.writeUTF("홍길동");
            dos.writeInt(25);
            dos.writeDouble(180.2);
            dos.writeChar('A');

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead() {
        try(DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))) {
            // 출력 순서대로 입력도 진행해야됨
//            System.out.println(dis.readInt()); // 650649
            while(true){
                System.out.println(dis.readUTF());  // 홍길동
                System.out.println(dis.readInt());  // 25
                System.out.println(dis.readDouble());  // 180.2
                System.out.println(dis.readChar());  // A

            }

            // DataInputStream은 더 읽어올 게 없으면 EOFException 에러남. (null이나 -1 특정 값 출력하지 않음)

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(EOFException e) {
            System.out.println("파일 읽어들이기 완료"); //IOE보다 상단에 있어야함.
        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println("프로그램을 종료합니다. ");
    }
}
