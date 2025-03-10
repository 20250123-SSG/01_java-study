package com.ino.section02.file_byte_stream;

import java.io.*;

public class FileByteDao {
    public void fileSave() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("a_byte.txt", true); // filenotfoundexception 발생 가능
            // 경로가 없는 경우 프로젝트 폴더에 만들어짐
            // 파일이 없으면 새로 만들어서 연결 / 있을 경우 그냥 연결
            fos.write(97);// 'a'
            fos.write('b');
            // fos.write('가'); // 한글은 1byte보다 크므로 깨져서 저장됨 -> 바이트스트림으로는 제한이 있음

            byte[] arr = new byte[]{99, 100, 101, 102};

            fos.write(arr); //'c' 'd' 'e' 저장
            fos.write(arr, 2, 2); // offset 2 ~ 2elements write

        } catch (FileNotFoundException e) {
            //미존재 경로 제시시 에러 발생
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFile() {
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = null;
        try {
            fis =  new FileInputStream("a_byte.txt");
//            byte[] bArr = fis.readAllBytes();
            int i;
            while((i = fis.read()) != -1) {
                sb.append((char) i);
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(sb.toString());
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
