package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N, K;
        int index = -1;
        int cnt = 0;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[] table;
        boolean[] eatable = new boolean[N];

        Arrays.fill(eatable, true);

        table = bf.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            if (table[i] == 'P') {
                int start = i - K;
                int end = i + K;
                if (start < 0) {
                    start = 0;
                }
                if (end > N - 1) {
                    end = N - 1;
                }
                for (int j = start; j <= end; j++) {
                    if (table[j] == 'H' && eatable[j]) {
                        eatable[j] = false;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
        System.out.println(Arrays.toString(eatable));
    }
}
