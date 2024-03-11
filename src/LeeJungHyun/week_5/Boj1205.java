package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1205 {
    public static void main(String[] args) throws IOException {
        int N, Score, P;

        int my_rank = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Score = Integer.parseInt(st.nextToken());

        P = Integer.parseInt(st.nextToken());

        if(N>0) {
            List<Integer> Rank = new ArrayList<>();

            st = new StringTokenizer(br.readLine());


            for (int i = 0; i < N; i++) {
                Rank.add(Integer.parseInt(st.nextToken()));
            }

            if (N==P && Score <= Rank.get(Rank.size() - 1)) {
                System.out.println("-1");
                return;
            } else {

                for (int r : Rank) {
                    if (Score < r)
                        my_rank++;
                }
            }
        }
        System.out.println(my_rank);
    }
}
