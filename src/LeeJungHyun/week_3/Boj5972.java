package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj5972 {

    static ArrayList<Node>[] graph; //Node형 ArrayList 배열 graph


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];

        for(int i=1;i<=N;i++)
            graph[i]=new ArrayList<>();

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,dist));
            graph[v].add(new Node(u,dist));// 방향성이 없는 그래프
        }
        dijkstra(N,1);

    }

    public static class Node implements  Comparable<Node>{

        int vertex,dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o){
            return this.dist-o.dist;
        }
    }

    public static void dijkstra(int n,int start){

        boolean[] visited=new boolean[n+1];
        int[] dist=new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);

        dist[start]=0;

        PriorityQueue<Node>pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){

            Node currentNode=pq.poll();
            if(visited[currentNode.vertex]){
                continue;
            }
            visited[currentNode.vertex]=true;

            for(Node nextNode: graph[currentNode.vertex]){
                if(dist[nextNode.vertex]>dist[currentNode.vertex]+ nextNode.dist) {
                    dist[nextNode.vertex] = dist[currentNode.vertex] + nextNode.dist;
                    pq.offer(new Node(nextNode.vertex, dist[nextNode.vertex]));
                }
            }
        }
        System.out.println(dist[n]);
    }
}
