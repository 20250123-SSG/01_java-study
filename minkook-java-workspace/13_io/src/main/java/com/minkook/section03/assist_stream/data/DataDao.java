package com.minkook.section03.assist_stream.data;

import java.io.*;

public class DataDao {
    public void fileSave(){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))){
            dos.writeUTF("홍길동");
            dos.writeInt(25);
            dos.writeDouble(180.2);
            dos.writeChar('A');

            dos.writeUTF("김말똥");
            dos.writeInt(35);
            dos.writeDouble(163.2);
            dos.writeChar('B');
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fileRead(){
        try(DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))){
            while(true){
                System.out.println(dis.readUTF() + " " +  dis.readInt() + " " + dis.readDouble() + " " +  dis.readChar());
            }

        }catch (EOFException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
