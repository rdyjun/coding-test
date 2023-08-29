import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int len = routes.length;
        int answer = 0;
        boolean[] visited = new boolean[len];
        int tmp = 0;
        int compareLine = Arrays.stream(routes)
            .mapToInt(v -> v[1])
            .min()
            .getAsInt();
        
        while (tmp != -1) {
            answer++;
            tmp = -1;
            for (int i = 0; i < len; i++) {
                if (visited[i])
                    continue;
                if (routes[i][0] <= compareLine && routes[i][1] >= compareLine) {
                    visited[i] = true;
                    continue;
                }
                if (tmp == -1 || routes[i][1] < tmp)
                    tmp = routes[i][1];
            }
            compareLine = tmp;
        }
        return answer;
    }
}