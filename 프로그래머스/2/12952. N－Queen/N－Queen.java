class Solution {
    
    private int n;
    
    public int solution(int n) {
        this.n = n;
        
        return dfs(-1, new boolean[n][n]);
    }
    
    private int dfs(int row, boolean[][] board) {
        if (row == this.n - 1) {
            return 1;
        }
        
        int result = 0;
        
        for (int i = 0; i < this.n; i++) {
            if (!validate(row + 1, i, board)) {
                continue;
            }
            
            boolean[][] tmpBoard = deepCopy(board);
            tmpBoard[row + 1][i] = true;

            result += dfs(row + 1, tmpBoard);
        }
        
        return result;
    }
    
    private boolean validate(int row, int col, boolean[][] board) {
        if (row == 0) {
            return true;
        }
        
        for (int i = 1; i <= row; i++) {
            if (board[row - i][col] ||
               (col - i >= 0 && board[row - i][col - i]) ||
               (col + i < n && board[row - i][col + i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean[][] deepCopy(boolean[][] board) {
        boolean[][] newBoard = new boolean[this.n][this.n];
        
        for (int i = 0; i < this.n; i++) {
            newBoard[i] = board[i].clone();
        }
        
        return newBoard;
    }
    
}