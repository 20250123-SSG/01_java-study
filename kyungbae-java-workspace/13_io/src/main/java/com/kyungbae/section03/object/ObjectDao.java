package com.kyungbae.section03.object;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDao {

    public void fileSave() {

        List<PersonDto> list = new ArrayList<>();
        list.add(new PersonDto("hong", 20, 184.5, 'A'));
        list.add(new PersonDto("kim", 30, 164.3, 'B'));
        list.add(new PersonDto("jang", 38, 169.3, 'C'));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_objext.txt"))) {

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
        List<PersonDto> list = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_objext.txt"))) {

            list = new ArrayList<>();
            while (true) {
//                System.out.println(ois.readObject());
                list.add((PersonDto)(ois.readObject())); // 강제 형변환
            }

        } catch (EOFException e) {
//            e.printStackTrace(); // 아무것도 안써도 됨 (메세지 없음)
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
