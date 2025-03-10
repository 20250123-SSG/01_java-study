package com.minkook.section01.file;

import java.io.File;
import java.time.LocalDate;

public class Application2 {
    public static void main(String [] args){


        LocalDate date = LocalDate.now();
        System.out.println(date);
        //String [] dateArr = date.toString().split("-");
        String dateNew = date.toString().replace('-','\\');
        //String year = dateArr[0];
        //String month = dateArr[1];
        //String day = dateArr[2];
        //File dir = new File("C:\\" + year +"\\" +  month+"\\" + day);
        File dir = new File("C:\\" + dateNew);
        //2) 존재할 경우 삭제
        if(dir.exists()){
            dir.delete();
        }
        System.out.println(dir + " 디렉토리가 삭제되었습니다.");



    }
}
