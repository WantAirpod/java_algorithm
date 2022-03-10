package Simul;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
9 8
antabtica
antaxtica
antadtica
antaetica
antaftica
antagtica
antahtica
antajtica
antaktica
 */
public class 백준_1062_가르침 {

    private static int n ;
    private static int k ;
    private static int max = 0;
    private static String[] arr ;
    private static boolean[] alpha2 = new boolean[26];
    static void beforeCheck(){
        //'a','n','t','i','c'
        alpha2['a' - 'a']  = true;
        alpha2['n' - 'a']  = true;
        alpha2['t' - 'a']  = true;
        alpha2['i' - 'a']  = true;
        alpha2['c' - 'a']  = true;
    }
    static void dfs(int start ,int cnt){
        if(cnt == k){
            int possible = 0 ;
            for(int i = 0 ; i < n; i++){
                boolean flagTrue = true;
                for(int j = 0 ; j < arr[i].length() ; j++){
                    if(!alpha2[arr[i].charAt(j)-'a']){
                        flagTrue = false;
                        break;
                    }
                }
                if(flagTrue == true){
                    possible++;
                }
            }
            max = Math.max(max,possible);
            return ;
        }


        for(int i = start ; i <=26 ; i++){
            if(!alpha2[i]){
                alpha2[i] = true;
                dfs(i,cnt+1);
                alpha2[i] = false;
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new String[n];
        if(k < 5){
            //flag = true; // 무조건 0
            System.out.println(0);
            return;
        }else if (k == 26 ){
            System.out.println(26);
            return;
        }else{
            for(int i = 0 ; i < n ; i ++){
                String tempStr = br.readLine();
                arr[i] = tempStr.substring(4,tempStr.length()-4);
            }
            k  = k - 5;
            beforeCheck();
            dfs(0,0);
            System.out.println(max);
        }
    }
}
