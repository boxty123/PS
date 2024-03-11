package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순열 만들기
public class Boj10974 {
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());

        int[]arr=new int[n];

        boolean[] visited=new boolean[n];

        for (int i=0;i<n;i++) arr[i]=i+1;

        perm(arr,visited,0,n,n);

        System.out.println(sb.toString());

    }

    static void perm(int[]arr,boolean []visited,int dep,int n,int r){

            if(dep==r){
                for(int i=0;i<n;i++) {
                    sb.append(arr[i] + " ");
                }
                sb.append("\n");
                return;
            }

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    visited[i]=true;
                    arr[dep]=i+1;
                    perm(arr,visited,dep+1,n,r);
                    visited[i]=false; //여길 다시 false로 만드는게 중요
                }
            }
    }
}
