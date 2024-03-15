package LeeJungHyun.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Boj9205 {

    static int test_case,store;
    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        test_case=sc.nextInt();
        store=sc.nextInt();

        pos []store_arr=new pos[store];

        pos start,end;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        start=new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        end=new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));


        int x,y;

    }

    static void bfs(int x,int y){


    }

    static int distance(int x1,int y1,int x2,int y2){
        return abs((x2-x1)+(y2-y1));
    }
    static class pos{
        int x,y;
        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
