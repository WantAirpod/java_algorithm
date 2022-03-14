package Simul;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_1789_수들의합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long sum = 0;
        long answer = 0;
        for(int i = 1 ; i <= n ; i++){
            sum += i;
            answer++;
            if(sum > n)
            {
                answer--;
                break;
            }
        }

        System.out.println(answer);
    }
}
