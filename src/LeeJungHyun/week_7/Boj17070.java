package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//왜 범위 검사를 먼저 해야 할까??

public class Boj17070 {

    static int N, cnt = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map=new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,1,1);

        System.out.println(cnt);

    }

    public static void dfs(int x, int y, int state) {

        if (x == N - 1 && y == N - 1) {
            cnt++;
            return;
        }

        if(state==1) {
            if (y + 1 < N && map[x][y + 1] == 0)
                dfs(x, y + 1, 1);
        }
        else if (state == 2){
            if(x + 1 < N && map[x + 1][y] == 0)
            dfs(x + 1, y, 2);
        }
        else if(state==3){
            if( x + 1 < N&& map[x + 1][y] == 0)
                dfs(x+1,y,2);
            if(y + 1 < N&& map[x][y+1] == 0)
                dfs(x,y+1,1);

        }
        if (x + 1 < N && y + 1 < N&&map[x + 1][y + 1] == 0 && map[x + 1][y] == 0 && map[x][y + 1] == 0) {
            dfs(x + 1, y + 1, 3);
        }
    }
}