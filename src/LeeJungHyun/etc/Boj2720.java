package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2720 {
    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());



        int Quarter,Dime,Nickel,Penny;

        int test=Integer.parseInt(st.nextToken());

        for(int i=0;i<test;i++){

            st=new StringTokenizer(br.readLine());

            sol(Integer.parseInt(st.nextToken()));

        }
    }

    private static void sol(int dollar) {

        int q=dollar/25;
        dollar=dollar%25;

        int d=dollar/10;
        dollar=dollar%10;

        int n=dollar/5;
        int p=dollar%5;

        System.out.println(q+" "+d+" "+n+" "+p);

    }
}
