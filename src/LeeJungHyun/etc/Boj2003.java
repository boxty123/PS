package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2003 {

    static int array[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        array = new int[N];

        int sum = 0, cnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {

            array[i] = Integer.parseInt(st.nextToken());

        }
        int pr = 0, pl = 0;

        while (pl < N && pr < N) {


            System.out.println(cnt);

        }

    }
}