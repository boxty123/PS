package LeeJungHyun.Bfs_Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//큐에 F와 J를 미리 넣고 bfs를 돌리면 안되는 이유? visit배열을 안쓰는 이유?

public class Boj4179 {

    static char[][] map;
    static int R, C;
    static int[][] Firedist;

    static Queue<Pos> fq = new LinkedList<>();
    static Queue<Pos> q = new LinkedList<>();



    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        dist = new int[R][C];

        Firedist = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                Firedist[i][j] = -1;
                dist[i][j] = -1;
            }
        }

        int fx = 0, fy = 0, x = 0, y = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'F') {
                    fq.offer(new Pos(i, j));
                    Firedist[i][j]=0;
                }
                if (map[i][j] == 'J') {
                    q.offer(new Pos(i, j));
                    dist[i][j]=0;
                }
            }
        }
        Firebfs();
        bfs();

    }

    public static void Firebfs() {


        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};


        while (!fq.isEmpty()) {
            Pos cur = fq.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && Firedist[nx][ny]<0 && map[nx][ny] != '#') {
                    Firedist[nx][ny] = Firedist[cx][cy] + 1;
                    fq.offer(new Pos(nx, ny));
                }
            }
        }
    }

    public static void bfs() {


        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, 1, -1, 0};


        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int cx = cur.x;
            int cy = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(dist[cx][cy] + 1);
                    return;
                }

                if (dist[nx][ny]<0&&map[nx][ny] != '#' && Firedist[nx][ny] > dist[cx][cy] + 1) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
