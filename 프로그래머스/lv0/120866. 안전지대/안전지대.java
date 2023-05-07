class Solution {
    public void ans (int[][] board, int i, int k) {
        if (board[i][k] != 1)
            board[i][k] = -1;
    }
    public int solution(int[][] board) {
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for (int k = 0; k < board.length; k++) {
                if(board[i][k] == 1) {
                    if(i != 0) {
                        if (k != 0) 
                            ans(board, i - 1, k - 1);
                        if (k != board.length - 1) 
                            ans(board, i - 1, k + 1);
                        ans(board, i - 1, k);
                    }
                    if (i != board.length - 1) {
                        if (k != 0) 
                            ans(board, i + 1, k - 1);
                        if (k != board.length - 1) 
                            ans(board, i + 1, k + 1);
                        ans(board, i + 1, k);
                    }
                    if (k != 0)
                        ans(board, i, k - 1);
                    if (k != board.length - 1)
                        ans(board, i, k + 1);
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for (int k = 0; k < board.length; k++) {
                if(board[i][k] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}