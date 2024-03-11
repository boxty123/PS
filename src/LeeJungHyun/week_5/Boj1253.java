package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//이중 for이랑 뭐가 다를까.
public class Boj1253  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int cnt = 0, sum = 0;

        for (int i = 0; i < N; i++) {

            int  left = 0, right = N - 1;

            int findNum = list[i];

            while (true) {
                if (left == i) left++;

                else if (right == i) right--;

                sum = list[left] + list[right];

                if(left>=right)
                    break;

                if (findNum == sum) {
                    cnt++;
                    break;
                } else if (findNum < sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(cnt);
    }
}
