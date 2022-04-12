package naver_financial;

public class naver_2번 {

    static int n = 3;
    static int m = 6;
    static int k = 3;
    static int answer;

    /**
     * @param checkN 현재 차선수
     * @param sumM 현재 더한 m 값
     * @param sumK 현재 더한 k 값
     * @param stateK 더할 수 있는 k 값
     */
    static void dfs(int checkN, int sumM, int sumK, int stateK){
        //만약 차선을 마지막 한개 남았다면
        if(stateK == 1){
            //마지막 차선은 총 너비에서 지금까지 너비의 합과 같다.
            //만약 마지막 차선의 너비가 제한된 k보다 크다면 return 한다.
            //만약 마지막 차선의 너비가 0이면 return 한다.
            if(m-sumM > k || m-sumM <=0)
                return;
            else{
                //만약 지금 분할한 차선의 갯수가 n과 같다면 answer를 더해준다.
                if(checkN==n){
                    answer++;
                    return;
                }else {
                    return;
                }
            }
        }
        for(int i = 1  ; i < m ; i ++) {
            if(i <= k){
                dfs(checkN+1, sumM+i, sumK+1, stateK-1);
            }

        }
    }

    public static void main(String[] args)  {

        dfs(1,0, 1,k);
        answer = answer % 1000007;
        System.out.println(answer);


    }
}
