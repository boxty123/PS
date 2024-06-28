package Nestnet.nestnet_algorithm_2023_2_advanced.JungHyunLee.week1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11725 { //부모 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        ArrayList<Integer>[] tree=new ArrayList[n+1];

        for(int i=1;i<=n;i++)
            tree[i]=new ArrayList<>();

        boolean[] visit=new boolean[n+1];

        int[] parent=new int[n+1];

        Queue<Integer>q = new LinkedList<>();

        for(int i=0;i<n-1;i++){
            int u,v;
            StringTokenizer st=new StringTokenizer(br.readLine());
            u=Integer.parseInt(st.nextToken());
            v=Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        q.add(1);

        while(!q.isEmpty()){
            int u=q.poll();
            for(int next:tree[u]){
                if(!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    parent[next]=u;
                }
            }
        }
        for(int i=2;i<=n;i++){
            System.out.println(parent[i]);
        }
    }
}
