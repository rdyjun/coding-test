import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = 1;
        int answer[] = new int[emergency.length];
        for(int i = 0; i < emergency.length; i++) {
            for(int k = 0; k < emergency.length; k++) {
                if (emergency[i] < emergency[k]) {
                    n++;
                }
            }
            answer[i] = n;
            n = 1;
        }
        
        return answer;
    }
}