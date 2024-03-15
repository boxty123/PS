package LeeJungHyun.DP;

import java.util.Scanner;

import static java.lang.Math.max;
//dp배열(지금까지의 총합)을 따로 생성하는 이유는? stair 배열로 안될까?
public class Boj2579 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int cnt=sc.nextInt();

        int[]stair=new int[cnt+2];
        int[]dp=new int[cnt+2];

        for(int i=1;i<cnt+1;i++)
            stair[i]=sc.nextInt();

        dp[1]=stair[1]; dp[2]=stair[1]+stair[2];
        for(int i=3;i<cnt+1;i++){
            dp[i]=max(stair[i-1]+dp[i-3],dp[i-2])+stair[i];
        }
        System.out.println(dp[cnt]);
    }
}
