package LeeJungHyun.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5014 {

    static int f, s, g, u, d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        int ret = bfs(s);
        if (ret == -1)
            System.out.println("use the stairs");
        else
            System.out.println(ret);
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[f + 1];
        int[] dist=new int[f+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        dist[start]=0;
        while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == g)
                    return dist[g];
                int up = cur + u;
                int down = cur - d;
                if (up <= f && !visited[up]) {
                    q.offer(up);
                    dist[up]=dist[cur]+1;
                    visited[up]=true;
                }
                if (down >= 1 && !visited[down]) {
                    q.offer(down);
                    dist[down]=dist[cur]+1;
                    visited[down]=true;
                }
            }
        return -1;
    }
}
