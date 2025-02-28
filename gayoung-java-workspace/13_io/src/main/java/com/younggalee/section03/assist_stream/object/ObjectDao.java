package com.younggalee.section03.assist_stream.object;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectDao {
    /*
    ## ObjectOutputStream / ObjectInputStream ##
    1. 객체 단위로 입출력할 수 있는 기능의 보조 스트림
    2. 단, 전달되는 객체는 직렬화가 가능한 상태여야됨.
        * 직렬화
        자바 객체를 외부에서 사용할 수 있도록
        바이트 형태로 데이터를 변환하는 기술
        (implements Serializable)
     */
    public void fileSave(){
        List<PersonDto> list = new ArrayList<>();
        list.add (new PersonDto("홍길동",25, 150.5,'A'));
        list.add (new PersonDto("홍길동동",25, 150.5,'B'));
        list.add (new PersonDto("홍길동동동",25, 150.5,'C'));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_object.txt"))) {
            for (PersonDto per : list){
                oos.writeObject(per); // NotSerializableException 발생 (객체는 직렬적이지 않음)
                // 직렬화해주기
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void fileRead(){
        List<PersonDto> list = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_object.txt"))) {
            while(true) {
                list.add((PersonDto) ois.readObject());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }catch (EOFException e) { // 다 읽으면 EOF 발생
            e.printStackTrace();
            System.out.println("여기");
        }catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        System.out.println(list );
    }

}
