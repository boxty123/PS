package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


//구현 방법이 상당히 어렵넹. 아이디어는 쉽다.
//1번을 누를때와 안누를때 나누는 이유?
public class Boj2138 {
    static int N;
    static boolean[] Bolt,myBolt,A,B;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Bolt=new boolean[N];

        myBolt=new boolean[N];

        int swtichA=1, switchB=0;

        changeBool(br.readLine(),Bolt);
        changeBool(br.readLine(),myBolt);

        A=new boolean[N];
        B=new boolean[N];

        for(int i=0;i<N;i++){
            if(i<=1){
                A[i]=!Bolt[i];
                B[i]=Bolt[i];
            }else{
                A[i]=Bolt[i];
                B[i]=Bolt[i];
            }
        }

        for(int i=1;i<N;i++){
            if(A[i-1]!=myBolt[i-1]){
                swtichA++;
                switchOn(i,A);
            }
            if(B[i-1]!=myBolt[i-1]){
                switchB++;
                switchOn(i,B);
            }

            if(Arrays.equals(A,myBolt)) {
                if (Arrays.equals(A, B)) {
                    System.out.println(Math.min(swtichA, switchB));
                    return;
                }

                System.out.println(swtichA);
                return;
            }else if(Arrays.equals(B,myBolt)){
                System.out.println(switchB);
                return;
            }
        }
        System.out.println(-1);
    }

    static void switchOn(int i,boolean[] b){
        b[i-1]=!b[i-1];
        b[i]=!b[i];
        if(i<N-1){
            b[i+1]=!b[i+1];
        }
    }

    static void changeBool(String a,boolean[]b){
        for(int i=0;i<N;i++){
            char n=a.charAt(i);
            if(n=='1'){
                b[i]=true;
            }else if(n=='0'){
                b[i]=false;
            }
        }
    }
}