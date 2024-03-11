package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

//숨박꼭질3. 순간이동 문제. 이런 방식의 bfs는 처음
public class Boj13549 {
    static int n, k;

    static int max = 100000;

    static int min=Integer.MAX_VALUE;

    static boolean[] visited = new boolean[max + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);

    }

    public static class node {
        public int pos, time;

        public node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }


    public static void bfs() {
        Queue<node>q=new LinkedList<>();
        q.offer(new node(n,0));

        while(!q.isEmpty()){
            node current=q.poll();
            visited[current.pos]=true;

            if(current.pos==k) min=Math.min(min,current.time);

            if(current.pos*2<=max&&!visited[current.pos*2])
                q.offer(new node(current.pos*2, current.time ));
            if(current.pos+1<=max&&!visited[current.pos+1])
                q.offer(new node(current.pos+1, current.time+1 ));
            if(current.pos-1>=0&&!visited[current.pos-1])
                q.offer(new node(current.pos-1, current.time+1 ));
        }
    }
}