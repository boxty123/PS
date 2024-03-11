package Nestnet.nestnet_algorithm_2023_2_advanced.LeeJungHyun.week_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
<<<<<<< HEAD
import java.util.StringTokenizer;
=======
>>>>>>> origin/main

//문자열 폭발

//스택에는 bomb이상의 문자열이 들어가지 않는다.

//s.size()-bomb.length()+j 가 뜻하는 의미: 스택에서 bomb의 첫 글자와 비교하기 위한 인덱스 접근
public class Boj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String myStr;
        String bomb;

        Stack<Character>s=new Stack<>();

        myStr=br.readLine();
        bomb=br.readLine();

        int bomb_len=bomb.length();

        for(int i=0;i<myStr.length();i++){

            s.push(myStr.charAt(i));

            if(s.size()>=bomb.length()){
                boolean isSame=true;
                for(int j=0;j<bomb.length();j++){
                    if(s.get(s.size()-bomb_len+j)!=bomb.charAt(j)){
                        isSame=false;
                        break;
                    }
                }
                if(isSame){
                    for(int j=0;j<bomb_len;j++){
                        s.pop();
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.size();i++)
                sb.append(s.get(i));
            if(sb.isEmpty())
                System.out.println("FRULA");
            else System.out.println(sb.toString());
    }

}
