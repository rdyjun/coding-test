class Solution {
    private int answer = 0;
    
    private void dfs (int[][] dungeons, int k, boolean[] visited, int idx, int n) {
        if (k < dungeons[idx][0] || visited[idx] || answer == dungeons.length) {
            if (this.answer < n)
                this.answer = n - 1;
            return;
        }
        
        if (n == dungeons.length) {
            answer = dungeons.length;
            return;
        }
        
        k -= dungeons[idx][1];
        visited[idx] = true;
        n++;
        
        for (int i = 0; i < dungeons.length; i++)
            dfs(dungeons, k, visited.clone(), i, n);
    }
    
    public int solution(int k, int[][] dungeons) {        
        for (int i = 0; i < dungeons.length; i++)
            dfs(dungeons, k, new boolean[dungeons.length], i, 1);
        
        return this.answer;
    }
}