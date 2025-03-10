package com.john.section03.assist_stream.data;

import java.io.*;

/*
    DataOutputStream/DataInputStream
    - 데이터 타입 입출력 보조 스트림
    - 데이터 자료형 별로 처리하는 기능이 추가되어있음

 */
public class DataDao {
    public void fileSave(){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))){

            // 객체 단위로 넣기가능 -> object package
            dos.writeUTF("홍길홍");
            dos.writeInt(25);
            dos.writeDouble(39.8);
            dos.writeChar('A');

            dos.writeUTF("김자료");
            dos.writeInt(83);
            dos.writeDouble(392.8);
            dos.writeChar('B');

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void fileRead(){
        try(DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))){
//            System.out.println(dis.readInt());
            System.out.println(dis.readUTF() + "," + dis.readInt() + "," + dis.readDouble() + "," + dis.readChar());
            System.out.println(dis.readUTF() + "," + dis.readInt() + "," + dis.readDouble() + "," + dis.readChar());
            System.out.println(dis.readUTF() + "," + dis.readInt() + "," + dis.readDouble() + "," + dis.readChar());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }catch (EOFException e){
            System.out.println("헉? EOF 발생");
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        catch (IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}
