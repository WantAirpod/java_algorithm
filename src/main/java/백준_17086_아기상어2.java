import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_17086_아기상어2 {

    static int n ;
    static int m ;
    static int[][] arr;
    static boolean[][] visit;
    static Queue<pair> q;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {-1,1,0,0,-1,-1,-1,1};
    static int answer = Integer.MIN_VALUE;
    static class pair{
        int x;
        int y;
        public pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static void maxMap(){

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(answer > arr[i][j]){
                    answer = arr[i][j];
                }
            }
        }
    }
    static void bfs(){

        while(!q.isEmpty()){
            int nowX = q.peek().x;
            int nowY = q.peek().y;
            q.poll();

            for(int w= 0 ; w < 8 ; w++){
                int nx = nowX + dx[w];
                int ny = nowY + dy[w];

                if(nx<0||ny<0||nx>=m||ny>=n){
                    continue;
                }
                if(arr[nx][ny] < arr[nowX][nowY]){
                    arr[nx][ny] = arr[nowX][nowY] + 1;
                    q.add(new pair(nx,ny));
                    visit[nx][ny] = true;
                    q.add(new pair(nx,ny));
                }else if(visit[nx][ny]){
                    if(arr[nx][ny] < arr[nowX][nowY]){
                        arr[nx][ny] = arr[nowX][nowY];
                        //q.add(new pair(nx,ny));
                    }else{
                        continue;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        //n= Integer.parseInt(st.nextToken());
        //m= Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        visit = new boolean[n+1][n+1];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==1) {
                    q.add(new pair(j,i));
                    visit[i][j] = true;
                }
            }
        }
        bfs();
        maxMap();
    }

}
