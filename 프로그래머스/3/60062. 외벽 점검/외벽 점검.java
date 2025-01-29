class Solution {
    private int weakLength;
    private int distLength;
    private int answer = Integer.MAX_VALUE;
    private int[] weak;
    private int[] dist;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.weakLength = weak.length;
        this.distLength = dist.length;
        this.weak = flattingWeakArray(n, weak);
        this.dist = dist;
        
        searchPermutation(0, new int[this.distLength], new boolean[this.distLength]);
        
        if (this.answer == Integer.MAX_VALUE) {
            return -1;
        }
        
        return this.answer;
    }
    
    private int[] flattingWeakArray(int n, int[] weak) {
        // weak을 2배로 설정하여 직선으로 관리 1, 4, 7  ->  1, 4, 7, 8(1), 11(4), 14(7)
        int[] flatWeak = new int[this.weakLength * 2];
        for (int weakIndex = 0; weakIndex < this.weakLength; weakIndex++) {
            flatWeak[weakIndex] = weak[weakIndex];
            flatWeak[weakIndex + this.weakLength] = weak[weakIndex] + n;
        }
        
        return flatWeak;
    }
    
    private void searchPermutation(int depth, int[] permutation, boolean[] visited) {
        if (depth == this.distLength) {
            // 각 시작점에서 해당 순열을 적용
            for (int startIndex = 0; startIndex < this.weakLength; startIndex++) {
                check(startIndex, permutation);
            }
            return;
        }
        
        for (int i = 0; i < this.distLength; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[depth] = this.dist[i];
                searchPermutation(depth + 1, permutation, visited);
                visited[i] = false;
            }
        }
    }
    
    private void check(int startIndex, int[] permutation) {
        int position = this.weak[startIndex] + permutation[0];
        int endIndex = startIndex + this.weakLength - 1;
        int friend = 1;
        
        for (int middleIndex = startIndex; middleIndex <= endIndex; middleIndex++) {      
            if (this.weak[middleIndex] > position) {
                if (friend >= this.distLength) {
                    return;
                }
                position = this.weak[middleIndex] + permutation[friend];
                friend++;
            }
            
            if (friend >= this.answer) {
                return;
            }
        }
        
        this.answer = Math.min(this.answer, friend);
    }
}