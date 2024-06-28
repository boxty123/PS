package Nestnet.nestnet_algorithm_2023_2_advanced.JungHyunLee.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1967 { //지름 구하기

    static LinkedList<node>[] tree;
    static boolean[] visit;
    static int max = 0,leaf_node=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        tree = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u, v, w;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            tree[u].add(new node(v, w));
            tree[v].add(new node(u, w));
        }

        visit = new boolean[n + 1];
        dfs(1, 0);

        visit = new boolean[n + 1];
        dfs(leaf_node,0);

        System.out.println(max);
    }


    private static class node {
        int num, dis;

        public node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
    }


    private static void dfs(int start, int dis) {

        visit[start] = true;

        if (dis > max) {
            max = dis;
            leaf_node = start;
        }

        for (node n : tree[start]) {
            if (!visit[n.num]) {
                visit[n.num] = true;
                dfs(n.num, dis + n.dis);
            }
        }
    }
}
