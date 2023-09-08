class Solution {
    private int answer = 0;
    
    private void dfs (int open, int close, int n) {
        if (n == open && n == close)
            this.answer++;
        
        if (n - open > 0)
            dfs(open + 1, close, n);
        if (n - close > 0 && n - open <= n - close)
            dfs(open, close + 1, n);
    }
    
    public int solution(int n) {
        dfs(1, 1, n);
        return this.answer;
    }
}