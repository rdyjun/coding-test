import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int answer[] = new int[score.length];
        int rank = 1;
        int[] arr = Arrays.asList(score).stream().map(v -> (v[0] + v[1])).mapToInt(v -> v).toArray();
        for(int i = 0; i < arr.length; i++){
            for (int k = 0; k < arr.length; k++) {
                if (arr[i] < arr[k])
                    rank++;
            }
            answer[i] = rank;
            rank = 1;
        }
        return answer;
    }
}