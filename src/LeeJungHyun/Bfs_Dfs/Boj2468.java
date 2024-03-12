package LeeJungHyun.Bfs_Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2468 {
    static int N, max_height = 0;
    static int[][] map;
    static int[][] dist;

    static boolean[][] visit;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        dist = new int[N][N];

        int ret = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if (map[i][j] > max_height)
                    max_height = map[i][j];
            }
        }

        for (int height = 0; height < max_height + 1; height++) {
            int cnt = 0;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (map[i][j] > height && !visit[i][j]) {
                        cnt += bfs(i, j, height);
                    }
            ret = Math.max(cnt, ret);
        }
        System.out.println(ret);
    }


    static int bfs(int x, int y, int water) {


        visit[x][y] = true;

        Queue<pos> q = new LinkedList<>();
        q.offer(new pos(x, y));

        while (!q.isEmpty()) {

            pos cur = q.poll();

            for (int i = 0; i < 4; i++) {

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) continue;
                if (map[nx][ny] > water && !visit[nx][ny]) {
                    q.offer(new pos(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
        return 1;
    }


    static class pos{
        int x,y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

