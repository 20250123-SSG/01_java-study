package com.inyoung.section03.assist_stream.object;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDao {
    /*
    ## ObjectOutputStream / ObjectInputStream
    객체 단위로 입출력 할 수 있는 기능의 보조 스트림
    단, 전달되는 객체는 직렬화가 가능한 상태여야됨

    * 직렬화
        자바 객체를 외부에서 사용할 수 있도록
        바이트(byte) 형태로 데이터를 변환하는 기술
 */

    public void fileSave() {
        List<PersonDto> list = new ArrayList<>();

        list.add(new PersonDto("김길규", 25, 180.2, 'A'));
        list.add(new PersonDto("김선녀", 35, 160.2, 'B'));
        list.add(new PersonDto("김규남", 35, 163.7, 'C'));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_object.txt"))) {

            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void fileRead() {

        List<PersonDto> list = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_object.txt"))) {

            while (true) {
                list.add((PersonDto) ois.readObject());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("완료");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        System.out.println(list);
    }

}
