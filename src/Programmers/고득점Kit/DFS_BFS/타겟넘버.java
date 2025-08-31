class Solution {
    public int solution(int[] numbers, int target) {
        int len=numbers.length;
        return dfs(numbers,target,0,0,len);
    }
    public int dfs(int[] numbers,int target, int index, int sum, int leaf){
        if(index==leaf) return sum==target? 1 : 0;
        else{
            return dfs(numbers,target,index+1,sum+numbers[index],leaf)+
                    dfs(numbers,target,index+1,sum-numbers[index],leaf);
        }
    }
}