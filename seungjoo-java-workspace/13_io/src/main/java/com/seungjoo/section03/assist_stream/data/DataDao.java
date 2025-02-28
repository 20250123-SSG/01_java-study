package com.seungjoo.section03.assist_stream.data;

import java.io.*;

public class DataDao {


    public void fileSave() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))) {
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
        try (DataInputStream dis = new DataInputStream(new FileInputStream("d_dateType.txt"))) {
            while (true) { // 파일 끝까지 읽도록 수정
                System.out.println(dis.readUTF() + " ," + dis.readInt() + " ," + dis.readDouble() + " ," + dis.readChar());
            } //DataInputStream은 파일을 다 읽으면 EOFException발생

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("파일 읽어들이기 완료");
        } catch (IOException e) { // 예외 타입 명시
            e.printStackTrace();
        }
    }
}

