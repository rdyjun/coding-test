class Solution {
    public int[] solution(int target) {
        int[][] dp = init(target); // [0] = 던진 수, [1] = 불, 싱글 수
        
        for (int i = 23; i <= target; i++) {
            if (dp[i][0] == 1) {
                continue;
            }
            
             for (int k = 1; k <= i / 2; k++) {
                 int throwCount = dp[k][0] + dp[i - k][0];
                 int bullSingleCount = dp[k][1] + dp[i - k][1];
                 
                 if (dp[i][0] == 0 || throwCount < dp[i][0] || (throwCount == dp[i][0] && bullSingleCount > dp[i][1])) {
                     dp[i][0] = throwCount;
                     dp[i][1] = bullSingleCount;
                 }
             }
        }
        return dp[target];
    }
    
    private int[][] init(int target) {
        int[][] dp = new int[Math.max(target + 1, 61)][2];
        dp[50][0] = 1;
        dp[50][1] = 1;
        for (int i = 1; i <= 20; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            
            dp[i * 2][0] = 1;
            dp[i * 2][1] = 0;
            
            dp[i * 3][0] = 1;
            dp[i * 3][1] = 0;
        }
        
        return dp;
    }
}
