package LeeJungHyun.etc;



public class Boj2743 {
        public int[] solution(int[] sequence, int k) {
            int[] answer = {};
            int len = sequence.length;

            int sum=0;
            int left=0,right=0;

            for(right=0;right<len;right++){

                while(left<=right) {
                    if (sum < k) {
                        sum = sum + sequence[right++];
                    }
                    else if(sum>k) sum=sum-sequence[left++];
                }


            }

            return answer;
        }
}
