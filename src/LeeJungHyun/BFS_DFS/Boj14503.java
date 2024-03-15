package LeeJungHyun.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14503 {

    static int N,M,r,c,d;
    static int[][]map;

    static int clear=1;
    public static void main(String[] args) throws IOException {




        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][M];

        st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r,c,d);
        System.out.println(clear);
    }

    static void clean(int x,int y,int dir) {

        map[x][y]=-1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};



        for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1)
                continue;
            if (map[nx][ny] == 0) {
                clear++;
                clean(nx, ny, dir);
                return;
            }
        }
        int D = (dir + 2) % 4;
        int backX = x + dx[D];
        int backY = y + dy[D];
        if (backX >= 0 && backX < N  && backY >= 0 && backY < M )
            if(map[backX][backY]!=1)
                clean(backX,backY,dir);

    }
}
