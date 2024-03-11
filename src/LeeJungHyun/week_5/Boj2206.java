package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 벽부수기
public class Boj2206 {

    static int n,m;
    static int map[][];

    static boolean visited[][][];
    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map= new int[n][m];
        visited= new boolean[n][m][2];


        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println();
    }


    public static void bfs(){


        int[]dx=new int[]{1,0,0,-1};
        int[]dy=new int[]{0,-1,1,0};

        Queue<node>q=new LinkedList<>();

        q.offer(new node(0,0,1,false));
        while (!q.isEmpty()){
            node current_node = q.poll();

            if(current_node.x==(n-1))
                if(current_node.y==(m-1)){
                System.out.println(current_node.dist);
                return;
            }

            for(int i=0;i<4;i++){
                int nx=current_node.x+dx[i];
                int ny=current_node.y+dy[i];
                int ndist=current_node.dist+1;


                if(nx<0||nx>n-1||ny<0||ny>m-1) continue;


                if(map[nx][ny]==0){
                    if(!current_node.crush){
                        if(visited[nx][ny][0]) continue;
                        visited[nx][ny][0]=true;
                        q.offer(new node(nx,ny,ndist,false));
                    }else{
                        if(visited[nx][ny][1]) continue;
                        visited[nx][ny][1]=true;
                        q.offer(new node(nx,ny,ndist,true));
                    }
                }else{
                    if(!current_node.crush){
                        visited[nx][ny][1]=true;
                        q.offer((new node(nx,ny,ndist,true)));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static class node{
        int x,y,dist;
        boolean crush;

        public node(int x, int y, int dist, boolean crush) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.crush = crush;
        }

    }
}
