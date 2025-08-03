package LeeJungHyun.BFS_DFS;

import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int[][] visited = new int[n][m];
        char[][] map = new char[n][m];
        for (int[] row : visited) Arrays.fill(row, -1);

        int cx = 0, cy = 0;
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    cx = i;
                    cy = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cx, cy});
        visited[cx][cy] = 0;

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x, ny = y;

                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || map[tx][ty] == 'D') break;
                    nx = tx;
                    ny = ty;
                }

                if (visited[nx][ny] != -1) continue;
                visited[nx][ny] = visited[x][y] + 1;
                if (map[nx][ny] == 'G') return visited[nx][ny];
                q.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }
}
