package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//지름길
//arr를 리스트형 배열로 선언하는 이유가 뭘까
public class Boj1446 {
    static ArrayList<Path>[] arr;
    public static void main(String[] args) throws IOException {
        int N, D;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1];

        arr = new ArrayList[10001];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < 10001; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end - start > cost)
                arr[end].add(new Path(start, cost));
        }

        dp[0]=0;

        for (int i = 1; i <= D; i++) {
            if (!arr[i].isEmpty()) {
                for (Path p : arr[i]) {
                    if (dp[p.start] + p.cost > dp[i]) continue;
                    dp[i] = Math.min(dp[i - 1] + 1, dp[p.start] + p.cost);
                }
                continue;
            }
            dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[D]);
    }

    public static class Path {
        int start, cost;

        public Path(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }
}
