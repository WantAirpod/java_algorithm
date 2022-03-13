package SK_ICT;

import java.util.LinkedList;
import java.util.Queue;

public class SK_1번_최소비용문제_BFS {
    static int money = 4578;

    static int[] dns = {1,5,10,50,100,500};
    static int[] cost = {1,4,99,35,50,1000};
    static boolean[] arr ;
    static int answer = 0;
    static Queue<Pair> q ;


    static void bfs(int[] cost){

        while(!q.isEmpty()){
            int nowCost = q.peek().cost;//현재 비용
            int nowSum = q.peek().sum; //현재 값
            q.poll();
            if(nowSum==4578){
                answer = nowCost;
            }

            if(nowSum == money){
                if(answer > nowSum){
                    answer = nowCost;
                }
            }else {
                int nextSum = nowSum;
                for(int i = 0 ; i < dns.length ; i++){
                    if(cost[i]==-1)
                        continue;
                    nextSum = nextSum + dns[i];
                    if(arr[nextSum]==false ){
                        arr[nextSum] = true;
                        q.add(new Pair(nowCost+cost[i] , nextSum));
                    }
                }
            }

        }

    }

    public static void main(String args[]) throws Exception{
        q = new LinkedList<Pair>();
        //checkCost(cost, dns);
        arr =new boolean[21470000];
        q.add(new Pair(0,0));
        bfs(cost);
        System.out.println(answer);
    }
    static class Pair{
        int cost;
        int sum;
        public Pair(int cost, int sum){
            this.cost = cost;
            this.sum = sum;
        }
    }
}

