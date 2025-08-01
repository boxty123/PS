package LeeJungHyun.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20055 { //컨베이어 벨트 위의 로봇


    // 옆으로 한칸씩 옮길 때 i를 줄이는 방법으로 해야 덮어 씌워지지 않고 모두 옮길 수 있다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;

        int[] belts = new int[2 * N];

        boolean[] robots = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * N; i++) {

            belts[i] = Integer.parseInt(st.nextToken());
        }

        while (check_duration(belts, K)) {
            move(belts, robots, N);
            cnt++;
        }


        System.out.println(cnt);

    }


    public static void move(int belts[], boolean robots[], int N) {

        int last = belts[belts.length - 1];
        for (int i = belts.length - 1; i > 0; i--)
            belts[i] = belts[i - 1];

        belts[0] = last;

        for (int i = robots.length - 1; i > 0; i--)
            robots[i] = robots[i - 1];
        robots[0] = false;

        robots[N - 1] = false;

        for (int i = N - 1; i > 0; i--) {
            if (belts[i] > 0 && !robots[i] && robots[i - 1]) {
                robots[i] = true;
                robots[i - 1] = false;
                belts[i]--;
            }
        }
        if (belts[0] > 0) {
            robots[0] = true;
            belts[0]--;
        }
    }


    public static boolean check_duration(int belts[], int k) {

        int cnt = 0;

        for (int i = 0; i < belts.length; i++) {
            if (belts[i] < 1)
                cnt++;
        }
        if (cnt >= k)
            return false;
        return true;

    }

}
