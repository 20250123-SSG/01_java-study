package com.minkook.section03.provide_functional_interface;

import java.util.function.Function;

public class Application3 {
    public static void main(String [] args){
        /*
            ## java.util.function.Function
         */

        Function<String,Integer> function = str -> Integer.parseInt(str);
        String strValue = "12345";
        System.out.println(function.apply(strValue) + " : " + function.apply(strValue).getClass().getName() );
    }
}
