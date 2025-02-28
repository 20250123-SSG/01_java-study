package com.john.section03.assist_stream.object;

/*
    ObjectOutputStream/ObjectInputStream
    - 객체 단위로 입출력할 수 있는 기능의 보조 스트림
    - 해당 클래스를 이용해 전달되는 객체는 직렬화가 가능한 상태여야됨

    직렬화=>Serializer
    - 자바 객체를 외부에서 사용할 수 있도록 바이트(byte)형태로 데이터를 변환하는 기술
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDao {
    public void fileSave() {

        List<PersonDto> list = new ArrayList<>();
        list.add(new PersonDto("홍길동", 25, 39.8, 'A'));
        list.add(new PersonDto("박조명", 85, 339.8, 'B'));
        list.add(new PersonDto("김도덕", 15, 149.8, 'C'));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d_dataType.txt"))) {

            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }

            for (PersonDto personDto : list) {
                oos.writeObject(personDto);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void fileRead() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_dataType.txt"))) {

            // readObject => 역직렬화 할 때 변환시킬 객체를 찾지 못할 가능성으로 ClassNotFoune가능성
            // 데이터를 다 읽의면 EOF에러 발생
            List<PersonDto> list = new ArrayList<>();

            while (true) {
                list.add((PersonDto) ois.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
