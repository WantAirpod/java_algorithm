import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
public class 백준_12345_정수삼각형 {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];

        }
        System.out.println(find(0,0));
    }

    static int find(int depth, int idx) {
        // 마지막 행일 경우 현재 위치의 dp값 반환
        if(depth == N - 1) {
            return dp[depth][idx];
        }
        // 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
        }
        return dp[depth][idx];

    }





}
