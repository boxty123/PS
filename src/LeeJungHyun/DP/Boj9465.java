package LeeJungHyun.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Boj9465 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int n;

        for (int i = 0; i < test; i++) {

            n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

                for (int k = 0; k < n; k++){
                    arr[0][k] = Integer.parseInt(st1.nextToken());
                    arr[1][k] = Integer.parseInt(st2.nextToken());
            }


            dp[0][0]=arr[0][0]; dp[1][0]=arr[1][0];
            dp[0][1]=dp[1][0]+arr[0][1];
            dp[1][1]=dp[0][0]+arr[1][1];


            for (int j = 2; j < n; j++) {
                dp[0][j]=max(dp[1][j-1],dp[1][j-2])+arr[0][j];
                dp[1][j]=max(dp[0][j-1],dp[0][j-2])+arr[1][j];

            }
            System.out.println(max(dp[0][n-1],dp[1][n-1]));

        }

    }
}
