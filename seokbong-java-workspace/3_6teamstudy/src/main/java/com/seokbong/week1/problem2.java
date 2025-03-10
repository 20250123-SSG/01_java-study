package com.seokbong.week1;

public class problem2 {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i < n+1; i++){
            if(n % i == 1){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
