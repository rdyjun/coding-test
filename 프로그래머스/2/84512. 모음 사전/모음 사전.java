import java.util.*;

class Solution {
    public int solution(String word) {
        int[] arr = new int[]{781, 156, 31, 6, 1};
        Map<Character, Integer> m = Map.of(
            'A', 0,
            'E', 1,
            'I', 2,
            'O', 3,
            'U', 4
        );
        
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            answer++;
            answer += m.get(word.charAt(i)) * arr[i];
        }
        return answer;
    }
}