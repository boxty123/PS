package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//if문좀 대신 써줘. -->출력도 한번에 해야 시간초과가 안뜬다.
public class Boj19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        String[] title=new String[n];
        int[] power=new int[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            title[i]=st.nextToken();
            power[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            int num=Integer.parseInt(br.readLine());

            int start=0; int end=n-1;

            while(start<=end){
                int mid=(start+end)/2;
                if(power[mid]<num)
                    start=mid+1;
                else
                    end=mid-1;
            }

            sb.append(title[start]).append("\n");
        }
        System.out.println(sb);
    }
}
