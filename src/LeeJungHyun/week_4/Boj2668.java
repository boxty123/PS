package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//숫자 고르기. 구현
public class Boj2668 {
    static int[] listA;

    static ArrayList<Integer> ret;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        listA=new int[N+1];
        visited=new boolean[N+1];

        ret=new ArrayList<>();



        for(int i=1;i<N+1;i++)
            listA[i]=Integer.parseInt((br.readLine()));

        for (int i=1;i<N+1;i++){
            visited[i]=true;
            dfs(i,i);
            visited[i]=false;
        }

        Collections.sort(ret);

        System.out.println(ret.size());

        for(Integer i:ret){
            System.out.println(i);
        }
    }


    public static void dfs(int start,int target){
        if(!visited[listA[start]]){
            visited[listA[start]]=true;
            dfs(listA[start],target);
            visited[listA[start]]=false;
        }
        if(listA[start]==target) ret.add(target);
    }
}
