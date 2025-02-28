package com.seungjoo.section03.assist_stream.object;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ObjectDao {

    public void fileSave(){

        List<PersonDto> list = new ArrayList<>();
        list.add(new PersonDto("홍길동", 25,180.2, 'a'));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_object.txt"))){

            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
            }


    }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void fileRead(){

        List<PersonDto> list = new ArrayList<>();
        try {
            ObjectInputStream ois  = new ObjectInputStream(new FileInputStream("e_object.txt"));

            while(true){
                list.add((PersonDto) ois.readObject());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }catch(EOFException e){
            System.out.println("파일 읽어들이기 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
