class Solution {
    
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int max = 0;
        
        if (row == 1 && col == 1) {
            return board[0][0];
        }
        
        int[][] dp = new int[row][col];
        for (int r = 0; r < row; r++) {
            dp[r][0] = board[r][0];
        }
        
        for (int c = 0; c < col; c++) {
            dp[0][c] = board[0][c];
        }
        
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (board[r][c] == 1) {
                    int a = dp[r - 1][c];
                    int b = dp[r][c - 1];
                    int d = dp[r - 1][c - 1];
                    
                    dp[r][c] = Math.min(Math.min(a, b), d) + 1;
                    
                    if (dp[r][c] > max) {
                        max = dp[r][c];
                    }
                }
            }
        }
        
        return max * max;
    }
    
}