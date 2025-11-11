class Solution {
    
    private static final String IMPOSSIBLE = "impossible";
    
    private final int[] arrival = new int[2]; // [row, col]
    
    private int m, n, k;
    private String answer = IMPOSSIBLE;
    private int[][] direction = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}}; // [y, x] dlru
    private char[] directionChar = new char[]{'d', 'l', 'r', 'u'};
    
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if ((x + y + r + c) % 2 != k % 2 || Math.abs(x - r) + Math.abs(y - c) > k) {
            return IMPOSSIBLE;
        }
        
        this.arrival[0] = r - 1;
        this.arrival[1] = c - 1;
        this.m = m;
        this.n = n;
        this.k = k;
        
        dfs(x - 1, y - 1, new StringBuilder());
        
        return this.answer;
    }
    
    private boolean dfs(int r, int c, StringBuilder history) {
        int dist = history.length();
        
        if (dist == this.k) {
            boolean isEnd = arrival[0] == r && arrival[1] == c;
            if (isEnd) {
                this.answer = history.toString();
            }
            
            return isEnd;
        }
        
        for (int dirIndex = 0; dirIndex < this.direction.length; dirIndex++) {
            int[] dir = this.direction[dirIndex];
            
            int nextRow = r + dir[0];
            int nextColumn = c + dir[1];
            
            int minDist = Math.abs(arrival[0] - nextRow) + Math.abs(arrival[1] - nextColumn);
            if (isWrongPosition(nextRow, nextColumn)
                || minDist >= this.k - dist) {
                continue;
            }
            
            history.append(directionChar[dirIndex]);
            boolean result = dfs(nextRow, nextColumn, history);
            history.deleteCharAt(dist);
            
            if (result) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isWrongPosition(int r, int c) {
        return r < 0
            || c < 0
            || r >= this.n
            || c >= this.m;
    }
}