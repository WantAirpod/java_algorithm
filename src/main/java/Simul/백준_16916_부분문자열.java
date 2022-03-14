package Simul;

/*
baekjoon
aek

baekjoon
abacaaba

abacaabaabacaabc
abacaabc

abacaababacaabc
abacaabc


table 예제
aacdaaedabd
aacdaad

** 답 **
** table[] = 0000120 **


testtable
abcdabce
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_16916_부분문자열 {

    static private String s;
    static private String p;
    static private boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        p = br.readLine();
        //System.out.println(KMP(s, p));
        KMP(s,p);
        if(flag){
            System.out.println(1);
        }else
            System.out.println(0);

    }

    static void KMP(String parent, String pattern) {
        int[] table = makeTable(pattern);

        int n1 = parent.length();
        int n2 = pattern.length();

        int idx = 0; // 현재 대응되는 글자 수
        for(int i=0; i< n1; i++) {
            // idx번 글자와 짚더미의 해당 글자가 불일치할 경우,
            // 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
            while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            // 글자가 대응될 경우
            if(parent.charAt(i) == pattern.charAt(idx)) {
                if(idx == n2-1) {
                    //System.out.println(i-idx+1 + "번째에서 찾았습니다. ~" + (i+1) );
                    flag = true;
                    idx =table[idx];
                }else {
                    idx += 1;
                }
            }
        }
    }

    static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++) {
            // 일치하는 문자가 발생했을 때(idx>0),
            // 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }

        return table;
    }
}


/*
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        s = br.readLine();
        p = br.readLine();

        //p의 길이 구하기
        int sizeOfp = p.length();
        //p의 첫글자 구하기
        char tempChar = p.charAt(0);
        String tempStr = "";
        //해당 글자 찾기
        int targetNum = 0 ;
        boolean flag = false;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)==tempChar){
                targetNum = i;
                try{
                    tempStr = s.substring(targetNum,targetNum+sizeOfp);
                }catch (Exception e){
                    flag=true;
                    System.out.println(0);
                    break;
                }
                if(tempStr.equals(p)){
                    flag = true;
                    System.out.println(1);
                    break;
                }
            }
        }
        if (!flag)
            System.out.println(0);
            }
    }*/

