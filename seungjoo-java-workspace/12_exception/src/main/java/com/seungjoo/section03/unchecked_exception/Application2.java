package com.seungjoo.section03.unchecked_exception;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Application2 {
    public static void main(String[] args) {



        try{
            new URL("https://www.google.com");
        }catch (MalformedURLException e){
            System.out.println("예외 발생");
        }
        try{
        new File("test.txt").createNewFile();
    }catch(IOException e){
        e.printStackTrace();}
    }
}
