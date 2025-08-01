package LeeJungHyun.week_7;

import java.util.Stack;

public class pairRemove {
    public int solution(String str){
        Stack<Character>stack=new Stack<>();
        for(char c : str.toCharArray()){
            if(!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty()? 1 : 0;
    }
}
