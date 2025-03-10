package com.jjanggu.practice3.controllar;

public class Function {

    public void printLottoNumbers(){

        int[] arr = new int[6];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 45 + 1);

            for(int j = 0; j < i ; j++){
                if(arr[j] == arr[i]){

                }
            }
        }


    }
}
