package naver_financial;

public class naver_2번_refectoring {

    static int n = 3;
    static int m = 6;
    static int k = 3;
    static int answer;
    static boolean[] visit;
    static void dfs(int props,int cnt){

        if(cnt == n){
            if(m - props > k) {
                return;
            }else if(m - props <= k){
                answer++;
                return;
            }
        }
        for(int i = props ; i < m ; i++){
            if(!visit[i]){
                visit[i] = true;
                if(props+i > m)
                    continue;
                dfs(i,cnt+1);
                visit[i] = false;
            }

        }
    }

    public static void main(String[] args)  {
        visit = new boolean[m];
        dfs(1, 1);
        answer = answer % 1000007;
        System.out.println(answer);
    }
}
