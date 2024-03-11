package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2631 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        int []array=new int[N];

        int []dp=new int[N];

        for(int i=0;i<N;i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            array[i] = Integer.parseInt(st.nextToken());

        }

        int LIS=1;

        for(int i=0;i<N;i++){
            
            dp[i]=1;

            for(int j=0;j<i;j++){

                if(array[j]<array[i])
                    dp[i]=Math.max(dp[j]+1,dp[i]);
            }
            LIS=Math.max(LIS,dp[i]);
        }
        System.out.println(N-LIS);
    }
}
