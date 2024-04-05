import java.util.Arrays;

class Solution {
    
    private static final Integer UNVISITED_VALUE = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], UNVISITED_VALUE);
        }
        
        for (int[] fare : fares) {
            dp[fare[0] - 1][fare[1] - 1] = fare[2];
            dp[fare[1] - 1][fare[0] - 1] = fare[2];
        }
        
        for (int k = 0; k < n; k++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (r == c) {
                        dp[r][c] = 0;
                        continue;
                    }
                    
                    if (dp[r][c] <= (long) dp[r][k] + dp[k][c]) {
                        continue;
                    }
                    
                    dp[r][c] = dp[r][k] + dp[k][c];
                }
            }
        }
        
        int answer = UNVISITED_VALUE;
        for (int i = 0; i < n; i++) {
            int value = dp[s - 1][i] + dp[i][a - 1] + dp[i][b - 1];
            
            if (answer > value) {
                answer = value;
            }
        }
        
        return answer;
    }
    
}