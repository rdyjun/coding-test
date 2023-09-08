class Solution {
    private int dfs (int open, int close, int n) {
        int answer = 0;
        if (n == open && n == close)
            return 1;
        
        if (n - open > 0)
            answer += dfs(open + 1, close, n);
        if (n - close > 0 && n - open <= n - close)
            answer += dfs(open, close + 1, n);
        return answer;
    }
    
    public int solution(int n) {
        return dfs(1, 1, n);
    }
}