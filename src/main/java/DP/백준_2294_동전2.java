package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_2294_동전2 {

    static ArrayList<Integer> list =new ArrayList<>();
    static int[] arr;
    static int[] dp;
    static int answer = 0;
    static int n = 0;
    static int k = 0;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n= Integer.parseInt(st.nextToken());
    k= Integer.parseInt(st.nextToken());
    arr =new int[n+1];
    dp = new int[k+1];
    dp[0] = 1;
}
