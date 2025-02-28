package com.ino.section3.assist_stream.convert;

import java.io.*;

public class ByteToCharDao {

    public void stdStream() {

        try {
            System.out.print("input : ");
            int input = System.in.read();
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stdStreamWithBuffer() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("input: ");
            String val = br.readLine();
            System.out.println(val);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void consoleOutput() {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write("hello world!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
