package naver_financial;

import java.util.HashSet;

public class naver_1번 {




    static boolean isCheck(int[][] tempArr){
        HashSet<Integer> testSet = new HashSet<>();
        for(int i = 0 ; i < 3 ; i++){
            int rowSum = 0;
            int coulumSum = 0;
            for(int j = 0 ; j < 3 ; j++){
                rowSum+= tempArr[i][j];
                coulumSum+=tempArr[j][i];
            }
            testSet.add(rowSum);
            testSet.add(coulumSum);
        }

        if(testSet.size() > 1)
            return false;
        else
            return true;
    }

    /**
     * 마방진 rule
     * @param testArr
     */
    static boolean magicSquare(int[] testArr){

        int[][] tempArr = new int[3][3];
        tempArr[0][1] = testArr[0];
        tempArr[2][0] = testArr[1];
        tempArr[1][2] = testArr[2];

        tempArr[2][2] = testArr[3];
        tempArr[1][1] = testArr[4];
        tempArr[0][0] = testArr[5];

        tempArr[1][0] = testArr[6];
        tempArr[0][2] = testArr[7];
        tempArr[2][1] = testArr[8];


        if(isCheck(tempArr)){
            return true;
        }else {
            return false;
        }

    }
    public static void main(String[] args)  {

        //int[][] numbers = {{1,2,3,4,5,6,7,8,9},{3,4,5,3,4,5,3,4,5},{2,2,2,2,2,2,2,2,2}};
        int [][] numbers = {{1,2,3,4,1,2,3,4,100},{1,2,1,2,1,2,1,2,1}};
        int[] answer = new int[numbers.length];

        for(int i = 0 ; i< numbers.length ; i++){
            int[] test = numbers[i];
            if(magicSquare(test)){
                answer[i]=1;
            }else {
                answer[i]=0;
            }
            System.out.println(answer[i]);
        }

    }
}
