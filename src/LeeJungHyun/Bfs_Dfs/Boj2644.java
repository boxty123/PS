package LeeJungHyun.Bfs_Dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2644 {

    static ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
    static int start,end;

    static boolean[]visit;

    static int[] dist;
    public static void main(String[] args) throws IOException {

        int n,m;

        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();

        dist=new int[n+1];

        visit= new boolean[n+1];

        start=sc.nextInt();

        end=sc.nextInt();

        m=sc.nextInt();

        for(int i=0;i<n+1;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        System.out.println(bfs(start,end));
    }


    static int bfs(int a, int b) {
        Queue<Integer>q=new LinkedList<>();
        visit[a]=true;
        dist[a]=0;

        q.offer(a);

        while(!q.isEmpty()){

            int index=q.poll();
            for(int i:arr.get(index)){
                if(!visit[i]){
                    dist[i]=dist[index]+1;
                    if(i==b)
                        return dist[i];
                    visit[i]=true;
                    q.offer(i);
                }
            }
        }
        return -1;
    }
}
