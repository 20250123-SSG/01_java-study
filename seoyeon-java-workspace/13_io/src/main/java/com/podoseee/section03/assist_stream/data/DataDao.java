package com.podoseee.section03.assist_stream.data;

import java.io.*;

public class DataDao {

    /*
        ## DataOutputStream/DataInputStream ##
        1. 데이터 타입 입출력 보조 스트림
        2. 데이터 자료형 별로 처리하는 기능이 추가되었음
     */

    public void fileSave(){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))) {

            dos.writeUTF("김수연");
            dos.writeInt(26);
            dos.writeDouble(196.8);
            dos.writeChar('A');

            dos.writeUTF("이서연");
            dos.writeInt(23);
            dos.writeDouble(157.1);
            dos.writeChar('B');

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead(){

        try(DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))) {

            // * 출력 순서대로 입력도 진행해야됨
            /*
            System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
            System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());

            System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
             */
            while(true){
                System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
            }
            // DataInputStream은 파일의 끝을 만나면 => EOFException 발생
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            System.out.println("파일 읽어들이기 완료");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
