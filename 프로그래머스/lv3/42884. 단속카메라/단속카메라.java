import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int len = routes.length;
        int answer = 1;
        Arrays.sort(routes, (v1, v2) -> Integer.compare(v1[1], v2[1]));
        int compareLine = routes[0][1];
        
        for (int i = 1; i < len; i++) {
            if (compareLine < routes[i][0]) {
                compareLine = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}