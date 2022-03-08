package DfsBfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
 */

/**
 * 2022.03.10 목 스터디
 */
public class 백준_1916_최소비용구하기  {
    private static int n;
    private static int m;
    private static int answer = 123456789;
    private static ArrayList<pair> list ;
    private static int s;
    private static int d;
    private static Queue<pairQueue> queue;

    private static int[][] arr;
    private static boolean[] visit;

    private static class pairQueue{
        int startPoint ;
        int totalValue ;
        public pairQueue(int startPoint, int totalValue ){
            this.startPoint = startPoint;
            this.totalValue = totalValue;
        }
    }
    private static class pair{
        int start ;
        int end ;
        int value ;
        public pair(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        queue = new LinkedList<>();
        arr = new int[m][m];
        visit = new boolean[m];
        for(int i = 0 ;i < m ; i ++){
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());  /* 시작점 */
            int desPoint = Integer.parseInt(st.nextToken());    /* 도착점 */
            int value = Integer.parseInt(st.nextToken());
            arr[startPoint][desPoint] =value;
            list.add(new pair(startPoint,desPoint,value));
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        queue.add(new pairQueue(s,0));
        bfs();
        System.out.println(answer);
    }
    private static void bfs(){
        while(!queue.isEmpty()){
            int nowStart = queue.peek().startPoint;
            int totalValue = queue.peek().totalValue;
            queue.poll();
            if(nowStart==d){
                if(answer > totalValue){
                    answer=totalValue;
                }
            }
            for(int i = 0 ; i < m ; i ++){
                if(list.get(i).start == nowStart){
                    queue.add(new pairQueue(list.get(i).end,totalValue+list.get(i).value));
                    //visit[i]=true;
                }
            }
        }
    }
}
