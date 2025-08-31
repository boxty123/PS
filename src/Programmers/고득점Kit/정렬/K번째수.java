import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            List<Integer> arr = new ArrayList<>();
            for (int i = command[0] - 1; i < command[1]; i++) {
                arr.add(array[i]);
            }
            Collections.sort(arr);
            answer.add(arr.get(command[2] - 1));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
