class Solution {
    public int solution(String[][] board, int h, int w) {
        String targetColor = board[h][w];
        int answer = 0;
        if (h > 0 && targetColor.equals(board[h - 1][w]))
            answer++;
        if (h < board.length - 1 && targetColor.equals(board[h + 1][w]))
            answer++;
        if (w > 0 && targetColor.equals(board[h][w - 1]))
            answer++;
        if (w < board[0].length - 1 && targetColor.equals(board[h][w + 1]))
            answer++;
            
        return answer;
    }
}