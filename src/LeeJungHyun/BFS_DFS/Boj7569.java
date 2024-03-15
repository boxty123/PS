package LeeJungHyun.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//삼차원 배열
//x,y,z 대신 col,row,height 표현 쓰기  삼차원 배열은 [height][row][col]순서로
public class Boj7569 {

    static int m, n, h;

    static int[][][] box;

    static Queue<pos>q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        q=new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1)
                        q.offer(new pos(i,j,k));
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {

        int[] dx = {-1, 0, 0, 1, 0, 0};
        int[] dy = {0, 1, -1, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};


        while (!q.isEmpty()) {

            pos cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx, ny, nz;
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                nz = cur.z + dz[i];
                if (nx < 0 || ny < 0 || nz < 0 || nx > m - 1 || ny > n - 1 || nz > h - 1) continue;
                if (box[nz][ny][nx] == 0) {
                    box[nz][ny][nx] =box[cur.z][cur.y][cur.x]+ 1;
                    q.offer(new pos(nz, ny, nx));
                }
            }
        }

        int ret=Integer.MIN_VALUE;

        for(int i=0;i<h;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<m;k++) {
                    if (box[i][j][k] == 0)
                        return -1;
                    ret=Math.max(ret,box[i][j][k]);
                }
        if(ret==-1) return 0;
        return ret-1;
    }


    static class pos {
        int x, y, z;

        public pos(int z, int y, int x) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
