package LeeJungHyun.week_7;

import java.util.Arrays;

class  Boat {
    public int boat(int[]people,int limit){
        int answer=0;
        Arrays.sort(people);
        int i=0;
        int j=people.length;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
            answer++;
        }
        return answer;
    }
}
