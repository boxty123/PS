import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);


        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == n - 1 && y == m - 1) return dist[x][y];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (0 <= nx && nx < n && 0 <= ny && ny < m
                        && maps[nx][ny] == 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }
}
