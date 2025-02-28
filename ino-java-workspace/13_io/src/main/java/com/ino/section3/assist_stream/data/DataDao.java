package com.ino.section3.assist_stream.data;

import java.io.*;

public class DataDao {

    public void saveFile() {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_dataType.txt"))) {
            dos.writeUTF("hongkildong");
            dos.writeInt(26);
            dos.writeDouble(180.2);
            dos.writeChar('A');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try(DataInputStream dis = new DataInputStream(new FileInputStream("d_dataType.txt"))) {
            System.out.println(dis.readUTF() + ", " + dis.readInt() + ", " + dis.readDouble() + ", " + dis.readChar());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
