package LeeJungHyun.DP;

import java.util.Scanner;

//test 케이스마다 새롭게 arr를 짜는게 아니라 한번 완성한후 값만 반복 출력

public class Boj9095 {
    public static void main(String[] args) {

        int []arr=new int[11];
        int test;

        arr[0]=0; arr[1]=1; arr[2]=2; arr[3]=4;
        for(int j=4;j<11;j++){
            arr[j]=arr[j-3]+arr[j-2]+arr[j-1];
        }
        Scanner sc=new Scanner(System.in);

        test=sc.nextInt();
        for(int i=0;i<test;i++) {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }
    }
}
