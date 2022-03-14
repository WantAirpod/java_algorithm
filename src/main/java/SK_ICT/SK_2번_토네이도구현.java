package SK_ICT;

public class SK_2번_토네이도구현 {
    static int[][] map;
    static int n = 6;
    //static int num = n-2;
    static int dirX = 0; //방금 끝났던 x 좌표
    static int dirY = 0; //방금 끝났던 y 좌표

    static boolean clockwise = true;
    static int value = 2;
    static void setting(){
        map[0][0] = 1;
        map[n-1][0] = 1;
        map[0][n-1] = 1;
        map[n-1][n-1] = 1;
    }
    static void woo(int num){
        dirY++;
        boolean flag = false;
        for(int i = 0 ; i < num ; i++){

            if(map[dirX][dirY] == 0) {
                map[dirX][dirY++] = value++;
                flag = true;
            }

            else if(map[dirX][dirY] > value){
                flag = true;
                map[dirX][dirY++] = value++;
            }

        }
        if(flag)
            dirY--;
    }

    static void ha(int num){
        dirX++;
        boolean flag = false;
        for(int i = 1 ; i <=num ; i++){
            if(map[dirX][dirY] == 0){
                flag = true;
                map[dirX++][dirY] = value++;
            }else if(map[dirX][dirY] > value){
                flag = true;
                map[dirX++][dirY] = value++;
            }
        }
        if(flag)
            dirX--;
    }
    static void ja(int num){
        dirY--;
        boolean flag = false;
        for(int i = num ; i >= 1 ; i-- ){
            if(map[dirX][dirY] == 0){
                flag = true;
                map[dirX][dirY--] = value++;
            }else if(map[dirX][dirY] > value) {
                flag = true;
                map[dirX][dirY--] = value++;
            }
        }
        if(flag)
            dirY++;
    }

    static void sang(int num){
        dirX--;
        boolean flag = false;
        for(int i = num ; i >=1 ; i-- ){
            if(map[dirX][dirY]==0){
                flag = true;
                map[dirX--][dirY] = value++;
            }else if(map[dirX--][dirY] > value){
                flag = true;
                map[dirX--][dirY] = value++;
            }
        }
        if(flag)
            dirX++;
    }


    static void solution(int n, boolean clockwise){
        setting();
        // true : 시계 방향, false : 반시계 방향
        if(clockwise){
            //좌상단
            int num = n-2;
            dirX = 0;
            dirY = 0;
            //좌상단
            while(num>0){
                //우
                woo(num);
                num--;
                //하
                ha(num);
                num--;
                ja(num);
                num--;
                sang(num);
                num--;
            }
            //우상단
            num = n-2;
            value = 2;
            dirX=0;
            dirY=n-1;
            while(num>0){
                //하
                ha(num);
                num--;
                //좌
                ja(num);
                num--;
                //상
                sang(num);
                num--;
                //우
                woo(num);
                num--;
            }
            //우하단
            num = n-2;
            value = 2;
            dirX=n-1;
            dirY=n-1;
            while(num>0){
                ja(num);
                num--;
                sang(num);
                num--;
                woo(num);
                num--;
                ha(num);
                num--;
            }
            //좌하단
            num = n-2;
            value = 2;
            dirX=n-1;
            dirY=0;
            while(num>0){
                sang(num);
                num--;
                woo(num);
                num--;
                ha(num);
                num--;
                ja(num);
                num--;
            }

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();


        }else{
            int num = n-2;
            value = 2;
            dirX = 0;
            dirY = 0;
            //좌상단
            while(num>0){
                ha(num);
                num--;
                woo(num);
                num--;
                sang(num);
                num--;
                ja(num);
                num--;
            }
            //좌하단
            num = n-2;
            value = 2;
            dirX=n-1;
            dirY=0;
            while(num>0){
                woo(num);
                num--;
                sang(num);
                num--;
                ja(num);
                num--;
                ha(num);
                num--;
            }
            //우하단
            dirX=n-1;
            value = 2;
            dirY=n-1;
            num = n-2;
            while(num>0){
                sang(num);
                num--;
                ja(num);
                num--;
                ha(num);
                num--;
                woo(num);
                num--;
            }
            //우상단
            dirX=0;
            dirY=n-1;
            value = 2;
            num = n-2;
            while(num>0){
                ja(num);
                num--;
                ha(num);
                num--;
                woo(num);
                num--;
                sang(num);
                num--;
            }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }

    }
    public static void main(String[] args) throws Exception {

        map = new int[n][n];
        solution(n,clockwise);



    }

}
