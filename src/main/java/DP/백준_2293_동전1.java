package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
3 10
1
2
5
 */

/**
 * 2022.03.15(화) DP 문제
 */
public class 백준_2293_동전1 {
    static ArrayList<Integer> list =new ArrayList<>();
    static int[] arr;
    static int[] dp;
    static int answer = 0;
    static int n = 0;
    static int k = 0;
    static void dfs(int sum){
        if(sum == k){
            answer++;
            return;
        }else if (sum > k){
            return;
        }

        for(int i = 0 ; i < arr.length ; i++){
            dfs(sum + arr[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        arr =new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            int num= Integer.parseInt(st.nextToken());
            arr[i] = num;
            for(int j = arr[i]; j<=k ; j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        //dfs 터진다.
        //dfs(0);

        System.out.println(dp[k]);

    }

}
