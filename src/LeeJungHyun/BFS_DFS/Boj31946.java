package LeeJungHyun.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj31946 {
    public static void main(String[] args) throws IOException {
        int n, m, jump;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        jump = Integer.parseInt(br.readLine());

        int color = map[0][0];

        Queue<pos> queue = new LinkedList<>();
        queue.add(new pos(0, 0));
        visited[0][0] = true;

        int[] dx = {1, -1, 0, 0,-1,-1,1,1};
        int[] dy = {0, 0, 1, -1,1,-1,-1,1};

        while (!queue.isEmpty()) {
            pos temp = queue.poll();
            if(temp.x == n-1 && temp.y == m-1){
                System.out.println("ALIVE");
                return;
            }

            for (int k = 0; k < 8; k++) {
                for (int j = 1; j <= jump; j++) {
                    int nx = temp.x + dx[k] * j;
                    int ny = temp.y + dy[k] * j;
                    int dist=Math.abs(dx[k]*j)+Math.abs(dy[k]*j);
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == color&&dist<=jump) {
                        queue.add(new pos(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println("DEAD");
    }

    static class pos {
        int x, y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
