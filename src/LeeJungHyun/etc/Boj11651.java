package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj11651 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<pos> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            list.add(new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);

        for(pos p:list)
            System.out.println(p.x+" "+p.y);
    }

    public static class pos implements Comparable<pos>{
        int x,y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(pos p){

            if(p.y==this.y)
               return this.x-p.x;
            else return this.y-p.y;
        }
    }
}