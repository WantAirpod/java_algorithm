package Simul;

import java.util.Scanner;
/*
3
CCP
CCP
PPC
 */
public class 백준_3085_사탕게임 {
    static char[][] arr;
    //static char[][] newArr;
    static boolean[][] visit;
    static int n;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;

    static int check(char[][] newArr){
        int maxNum = -987654321;
        //행체크
        for(int i = 0 ; i < arr.length ; i++){
            int tempCnt = 1 ;
            for(int j = 0 ; j < arr.length-1 ; j++){
                if(newArr[i][j] == newArr[i][j+1]){
                    tempCnt++;
                }else{
                    if(maxNum < tempCnt){
                        maxNum = tempCnt;
                    }
                    tempCnt = 1;
                }
            }

        }
        //열체크
        for(int i = 0 ; i < arr.length ; i++){
            int tempCnt = 1;
            for(int j = 0 ; j < arr.length-1 ; j++){
                if(newArr[j][i] == newArr[j+1][i]){
                    tempCnt++;
                }else{
                    if(maxNum < tempCnt){
                        maxNum = tempCnt;
                    }
                    tempCnt = 1;
                }
            }
        }

        return maxNum;
    }
    static void simul(char[][] newArr){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length; j++){
                int nowX = i;
                int nowY = j;
                for(int w = 0 ; w < 4 ; w++){
                    int nx = i + dx[w];
                    int ny = j + dy[w];
                    if(nx < 0 || nx > n || ny < 0 || ny > n){
                        continue;
                    }
                    if(visit[nx][ny]){
                        continue;
                    }
                    if(newArr[nx][ny] != newArr[i][j]){
                        char tempChar123 = newArr[i][j];
                        newArr[i][j] = newArr[nx][ny];
                        newArr[nx][ny] = tempChar123;
                        if(check(newArr) > answer){
                            answer = check(newArr);
                        }
                        //newArr 원복
                        newArr = arr.clone();
                    }else if(arr[nx][ny] == arr[i][j]){
                        continue;
                    }
                }
            }
        }//end for i





    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();// 5
        arr = new char[n][n];
        visit = new boolean[n][n];
        //newArr = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] tempChar = sc.next().toCharArray();
            //newArr[i] = tempChar;
            arr[i] = tempChar;

        }
        simul(arr);
        System.out.println(answer);



    }
}
