package Nestnet.nestnet_algorithm_2023_2_advanced.JungHyunLee.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 { //연구소. 백트랙킹. n과m이 매우 작다.

    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int safe = create_wall(0);
        cnt = Math.max(safe, cnt);

        System.out.println(cnt);
    }

    private static int create_wall(int cnt) {
        if (cnt == 3) {
            return spread_virus();
        }
        int max_safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    max_safe = Math.max(max_safe, create_wall(cnt + 1));
                    map[i][j] = 0;
                }
            }
        }
        return max_safe;
    }

    public static int spread_virus() {
        Queue<Points> q = new LinkedList<>();
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    q.add(new Points(i, j));
                }
            }
        }

        int[][] copy_map = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy_map[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            Points current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < n && nextY < m && nextX >= 0 && nextY >= 0) {
                    if (copy_map[nextX][nextY] == 0) {
                        q.add(new Points(nextX, nextY));
                        copy_map[nextX][nextY] = 2;
                    }
                }
            }
        }
        return count_safe(copy_map);
    }

    public static class Points {
        public int x, y;

        Points(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int count_safe(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
