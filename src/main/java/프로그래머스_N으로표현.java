public class 프로그래머스_N으로표현 {

    private static int n;
    private static int target;
    private static int answer = Integer.MAX_VALUE;

    public static int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 1; i < 9; i++) {

            dfs(count+i, prev + tempN);
            dfs(count+i, prev - tempN);
            dfs(count+i, prev / tempN);
            dfs(count+i, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }


    public static void main(String[] args) throws Exception {
        //n = 12;
        //target = number;
        solution(5,12);
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);
    }
}
