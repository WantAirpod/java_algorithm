package Algorithm.twoPointAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
4 2
1 1 1 1

10 5
1 2 3 4 2 5 3 1 1 2
 */
public class 백준_2003_수들의합2 {

    static ArrayList<Integer> list;
    static int[] arr ;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        list = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i =0 ; i < n ; i ++){
            int num = Integer.parseInt(st.nextToken());
            arr[i]=num;
            list.add(num);
        }

        int s = 0;
        int e = 0;
        int sum = 0 ;
        while(true) {
            if(sum>=m) {
                sum -= arr[s++];
            }else if(e==n) break;
            else {
                sum += arr[e++];
            }
            if(sum==m) {
                answer++;
            }

        }
        System.out.println(answer);
    }
}
