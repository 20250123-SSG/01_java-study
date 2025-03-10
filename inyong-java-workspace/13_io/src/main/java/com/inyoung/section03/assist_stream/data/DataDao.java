package com.inyoung.section03.assist_stream.data;

import java.io.*;

public class DataDao {

    /*
    ## DataOutputStream/DataInputStream ##

    1. 데이터 타입 입출력 보조 스트림
    2. 데이터 자료형 별로 처리하는 기능이 추가되었음
     */

    public void filesave() {

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))) {

            dos.writeUTF("홍길동");
            dos.writeInt(25);
            dos.writeDouble(180.2);
            dos.writeChar('A');

            dos.writeUTF("홍길동");
            dos.writeInt(25);
            dos.writeDouble(180.2);
            dos.writeChar('A');

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

    public void fileRead() {


        try (DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))) {
            while (true) {
                System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + "," + dis.readChar());
            } //
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("파일 읽어드리기 완료");
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
