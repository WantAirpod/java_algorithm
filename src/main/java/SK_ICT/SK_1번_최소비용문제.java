package SK_ICT;

public class SK_1번_최소비용문제 {
    static int money = 4578;
    static int[] cost = {1,4,99,35,50,1000};
    static int[] dns = {1,5,10,50,100,500};
    static int minNum = 987654321;
    static int answer = 0;
    static void dfs(int sum, int costNum){
        if(sum == money){
            if(costNum < minNum){
                minNum = costNum;
            }
        }else if(sum > money){
            return;
        }else if(costNum > money){
            return;
        }


        for(int i = dns.length-1 ; i >= 0 ; i--){
            System.out.println();
            dfs(sum+dns[i],costNum+cost[i]);
            System.out.println();
        }

    }
    public static void main(String args[]) throws Exception{

        dfs(0,0);
        System.out.println(answer);


    }
}
