package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj4485{  //pq 사용법과 다익스트라 알고리즘

    private static int N=1;
    private static int[][] map;
    private static int[][] cost;

    public static void main(String[] args) throws IOException {


        map = new int[N][N];

        cost = new int[N][N];

        int test_case=1;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {

            StringTokenizer st=new StringTokenizer(br.readLine());


            N=Integer.parseInt(st.nextToken());

            if(N==0)
                return;

            map=new int[N][N];

            cost =new int[N][N];

            for(int i=0; i<N; i++) {
                st=new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                    cost[i][j]=Integer.MAX_VALUE;
                }
            }

            cost[0][0]=map[0][0];

            bfs(0,0);

            int ret=cost[N-1][N-1];

            System.out.println("Problem "+test_case+": "+ ret);

            test_case++;
        }
    }


    public static void bfs(int startX,int startY) {



        PriorityQueue<Points>pq=new PriorityQueue<>();

        int[] dx= {1,0,0,-1};
        int[] dy= {0,-1,1,0};


        pq.add(new Points(startX,startY, map[0][0]));

        while(!pq.isEmpty()) {


            Points current = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];
                if (nextX < N && nextY < N && nextX >= 0 && nextY >= 0)
                    if (cost[current.x][current.y]+ map[nextX][nextY]<cost[nextX][nextY]) {
                        cost[nextX][nextY] = cost[current.x][current.y] + map[nextX][nextY];
                        pq.add(new Points(nextX, nextY,cost[nextX][nextY]));
                    }
            }
        }
    }

    public static class Points implements Comparable<Points>{

        public int x,y,cost;

        Points(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
        @Override
        public int compareTo(Points o) {
            return this.cost-o.cost;
        }
    }

}