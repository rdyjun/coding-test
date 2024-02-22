import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int[][] dp = new int[1000000][2];
        
        for(int[] edge : edges) {
            dp[edge[0] - 1][0]++;
            dp[edge[1] - 1][1]++;
        }
        
        for(int i = 0; i < 1000000; i++) {
            if(dp[i][0] == 0 && dp[i][1] == 0)
                break;
            
            if(dp[i][1] == 0 && dp[i][0] > 1) {
                answer[0] = i + 1;
                continue;
            }
            
            if(dp[i][0] == 0) {
                answer[2]++;
                continue;
            }
            
            if(dp[i][0] > 1 && dp[i][1] > 1) {
                answer[3]++;
                continue;
            }
        }
        
        answer[1] = dp[answer[0] - 1][0] - answer[2] - answer[3];
            
        return answer;
    }
}