package com.ino.section3.assist_stream.object;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectDao {
    public void saveFile() {
        List<PersonDto> personList;
        personList = Arrays.asList(
                new PersonDto("ino1", 20, 101.1, 'a'),
                new PersonDto("ino2", 21, 102.2, 'b'),
                new PersonDto("ino3", 22, 103.3, 'c'),
                new PersonDto("ino4", 23, 104.4, 'd'),
                new PersonDto("ino5", 24, 105.5, 'e'),
                new PersonDto("ino6", 25, 106.6, 'f'),
                new PersonDto("ino7", 26, 107.7, 'g'),
                new PersonDto("ino8", 27, 108.8, 'h'),
                new PersonDto("ino9", 28, 109.9, 'i'),
                new PersonDto("ino10", 29, 110.0, 'j'));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_object.txt"))) {
            for(PersonDto p : personList) {
                oos.writeObject(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        List<PersonDto> personDtoList = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_object.txt"))) {
            while(true) {
                personDtoList.add((PersonDto) ois.readObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
