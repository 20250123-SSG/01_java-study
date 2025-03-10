package com.sotogito.section03.data;

import java.io.*;

public class DataDao {
    /**
     * ## DataOutputStream / DataInputStream
     * 1. 데이터 타입 입출력 보조 스트림
     * 2. 데이터 자료형 별로 처리하는 기능이 추가되어있음
     */
    public void fileSave() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))) {

            dos.writeUTF("이서연");
            dos.writeInt(0);
            dos.writeDouble(142.2);
            dos.writeChar('F');

            dos.writeUTF("김말똥");
            dos.writeInt(35);
            dos.writeDouble(163.2);
            dos.writeChar('B');


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))) {
//
//            System.out.println(dis.readUTF());
//            System.out.println(dis.readInt());
//            System.out.println(dis.readDouble());
//            System.out.println(dis.readChar());
//
//            System.out.println(dis.readUTF());
//            System.out.println(dis.readInt());
//            System.out.println(dis.readDouble());
//            System.out.println(dis.readChar());

            while (true) {

                System.out.println(dis.readInt());
                System.out.println(dis.readDouble());
                System.out.println(dis.readChar());
                System.out.println(dis.readUTF());
            }
        } catch (EOFException e) { //파일의 끝을 발견할 시

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
