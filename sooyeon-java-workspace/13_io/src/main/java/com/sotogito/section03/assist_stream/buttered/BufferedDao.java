package com.sotogito.section03.assist_stream.buttered;

import java.io.*;

public class BufferedDao {
    /**
     * ## 보조 스트림
     * 1. 기반 스트림으로 부족한 성능 및 기능을 향상시켜주는 스트림
     * 2. 단독으로 사용 불가 - 생성시 기반 스트림 인스턴스 전달해야함
     * <p>
     * ## BufferedWriter / BufferedReader
     * 1. 입출력 데이터를 저장할 수 있는 내부 버퍼 있음
     * 2. 버퍼에 데이터를 모아 한번에 입출력하여 출력 속도 향상됨
     */

    /*
    public void fileSave() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("c_buffer.txt"));

            bw.write("안녕하세요.\n");
            bw.write("반가.\n");
            bw.newLine();
            bw.write("어서오세요");

            /// 버퍼에 가득 차야만 데이터가 출력됨
            /// 강제로 출력할 경우
            //bw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     */
    public void fileSave() {
        /**
         * ## try-write-resource
         * 스트림을 다 사용하면 자동으로 반납
         * JDK 1.7~
         *
         * try(사용할 스크림객체 생성){
         *      -> 끝나면 자동을 반남합
         * }catch(예외){
         * }
         */

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))) {
            bw.write("안녕하세요.\n");
            bw.write("반가.\n");
            bw.newLine();
            bw.write("어서오세요");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileRead() {
        try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
//            String value = null;
//            while ((value = br.readLine()) != null) {
//                System.out.println(value);
//            }

            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileCopy() {
        /**
         * 파일 복사 : 기존의 파일을 가져와서 새로운 파일로 기록
         *
         * 기존파일 -> 데이터 -> 프로그램 ->데이터 -> 새로운파일
         */

        /// 복사할 파일
        File origin = new File("C:\\dev\\env\\jdk-17.0.14_7", "NOTICE");
        /// 복사될 파일
        File copy = new File("C:\\storage", origin.getName());

        try(BufferedReader in = new BufferedReader(new FileReader(origin));
            BufferedWriter out = new BufferedWriter(new FileWriter(copy))){

            while (in.ready()) {
                out.write(in.readLine());
            }

            System.out.println(copy.getPath()+"파일 복사 완료");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
