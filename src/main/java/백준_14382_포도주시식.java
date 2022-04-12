import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
6
6
10
13
9
8
1
 */
public class 백준_14382_포도주시식 {
    static int n ;
    static int[] arr;
    static int[] dp;
    static int maxNum = -987654321;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        dp = new int[n+1];
        for(int i = 1  ; i <= n ; i ++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            arr[i] = m;
        }

        dp[1] = arr[1];

        if(n>1){
            dp[2] = arr[1] + arr[2];
        }

        for(int i = 3 ; i <= n ; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }





        System.out.println(dp[n]);
    }
}
