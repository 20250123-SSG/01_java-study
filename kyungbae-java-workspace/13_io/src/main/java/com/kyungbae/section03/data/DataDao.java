package com.kyungbae.section03.data;

import java.io.*;

public class DataDao {

    // DataOutputStream / DataInputStream
    public void fileSave(){

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))) {

            dos.writeUTF("홍길동");
            dos.writeInt(25);
            dos.writeDouble(180.2);
            dos.writeChar('A');

            dos.writeUTF("김동동");
            dos.writeInt(30);
            dos.writeDouble(160.2);
            dos.writeChar('B');

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void fileRead(){
        try(DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))) {

            // 출력 순서대로 입력도 진행햐야됨
            /*
            System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
            System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
            System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
             */
            // EOFException 발생 (End Of File) => IOException의 하위 Exception
            while(true){
                System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
            }

        }catch (EOFException e) {
            System.out.println("파일 읽기 완료");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("프로그램종료");

    }

}
