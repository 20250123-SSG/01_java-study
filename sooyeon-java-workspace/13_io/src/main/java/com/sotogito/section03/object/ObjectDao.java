package com.sotogito.section03.object;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDao {
    /**
     * ## ObjectOutputStream / ObjectInputStream
     * 1. 객체 단위로 입출력 할 수 있는 기능의 보조 스트랩
     * 2. 전달되는 객체는 직렬화 가능해야됨
     * <p>
     * - 직렬화 : 자바 객체를 외부에서 사용할 수 있도록 바이트 형태로 데이터를 변환
     */

    public void fileSave() {
        List<PersonDto> list = new ArrayList<>();
        list.add(new PersonDto("ewfw", 25, 1234.1, 'A'));
        list.add(new PersonDto("wfw", 252, 1234.3, 'B'));
        list.add(new PersonDto("eqwfwfw", 125, 34.1, 'c'));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_object.txt"))) {

            //.NotSerializableException: com.sotogito.section03.object.PersonDto 직렬화가 되지 않았을 때 예외
            for (PersonDto person : list) {
                oos.writeObject(person);
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

        } catch (EOFException e) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(list);
    }
}