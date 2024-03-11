package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
//replaceALl
public class Boj2864 {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        String a= st.nextToken();
        String b=st.nextToken();

        int max_a=Integer.parseInt(a.replaceAll("5","6"));
        int max_b=Integer.parseInt(b.replaceAll("5","6"));


        int min_a=Integer.parseInt(a.replaceAll("6","5"));
        int min_b=Integer.parseInt(b.replaceAll("6","5"));


        System.out.print(min_a+min_b+" ");
        System.out.println(max_a+max_b);

    }
}
