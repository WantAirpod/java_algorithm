import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_네트워크 {
    static int n = 3;
    static int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};;
    static class Pair{
        int x ;
        int y ;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Pair> q;
    static int answer =0;
    static void bfs(){


        while (!q.isEmpty()){

            int nowX = q.peek().x;
            int nowY = q.peek().y;
            q.poll();
            answer++;
        }

    }
    public static void main(String[] args) throws Exception {
        n = 3;
        q = new LinkedList<>();
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(i==j){
                    continue;
                }
                if(computers[i][j] == 1){
                    q.add(new Pair(i,j));
                }
            }
        }
        bfs();
    }
}
