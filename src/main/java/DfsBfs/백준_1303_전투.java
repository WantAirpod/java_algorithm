package DfsBfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
5 5
WBWWW
WWWWW
BBBBB
BBBWW
WWWWW
 */
public class 백준_1303_전투 {
    static int n ;
    static int m ;
    static int[][] arr;
    static boolean[][] visit;

    static Queue<Pair> wq;
    static Queue<Pair> bq;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

//    static int wSum = 1;
    static int wAnswer =0;
//    static int bSum = 0;
    static int bAnswer = 0;
    static ArrayList<Integer> answerList = new ArrayList<>();
    static class Pair{
        int x ;
        int y ;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int wBfs(){

        int wSum = 1;
        while(!wq.isEmpty()){
            int nowX = wq.peek().x;
            int nowY = wq.peek().y;
            wq.poll();
            for(int w = 0 ; w < 4 ; w++){
                int nx = nowX + dx[w];
                int ny = nowY + dy[w];
                if(nx < 0 || nx >=n || ny <0 || ny >=m){
                    continue;
                }
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny]==0) {
                    wSum += 1;
                    visit[nx][ny] = true;
                    wq.add(new Pair(nx,ny));
                }else{
                    continue;
                }
            }
        }

        return wSum * wSum;

    }
    static int bBfs(){
        int bSum = 1;
        while(!bq.isEmpty()){
            int nowX = bq.peek().x;
            int nowY = bq.peek().y;
            bq.poll();
            for(int w = 0 ; w < 4 ; w++){
                int nx = nowX + dx[w];
                int ny = nowY + dy[w];
                if(nx < 0 || nx >=n || ny < 0 || ny >=m){
                    continue;
                }
                if(visit[nx][ny])
                    continue;
                if(arr[nx][ny]==1) {
                    bSum += 1;
                    visit[nx][ny] = true;
                    bq.add(new Pair(nx,ny));
                }else{
                    continue;
                }

            }
        }

        return bSum * bSum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m= Integer.parseInt(st.nextToken());
        n= Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0 ; j < str.length() ; j ++){
                char ch = str.charAt(j);
                if(ch == 'W'){
                    arr[i][j] = 0;
                }else if(ch == 'B') {
                    arr[i][j] = 1;
                }
            }
        }

        //queue
        wq = new LinkedList<>();
        bq = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[i][j] == 0 && !visit[i][j]){
                    wq.add(new Pair(i,j));
                    visit[i][j] = true;
                    int sumOfW = wBfs();
                    //sumOfW = sumOfW * sumOfW;
                    //System.out.println(sumOfW);
                    wAnswer += sumOfW;
                    //answerList.add(wAnswer);
                }else if(arr[i][j] == 1 && !visit[i][j]){
                    bq.add(new Pair(i,j));
                    visit[i][j] = true;
                    int sumOfB = bBfs();
                    //sumOfB = sumOfB * sumOfB;
                    //System.out.println(sumOfB);
                    bAnswer += sumOfB;
                }
            }
        }
        System.out.println(wAnswer+" "+bAnswer);
    }
}
