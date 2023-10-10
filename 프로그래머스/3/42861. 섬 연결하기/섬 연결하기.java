import java.util.*;

class Solution {
    private int[] parent;
    
    private int findParent (int n) {
        if (this.parent[n] != n)
            return this.parent[n] = findParent(this.parent[n]);
        return n;
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (v1, v2) -> Integer.compare(v1[2], v2[2]));
        parent = new int[n];
        
        for (int i = 0; i < n; i++)
            parent[i] = i;
        
        int answer = 0;
        int from, to;
        
        for (int[] cost : costs) {
            from = cost[0];
            to = cost[1];
            
            if (findParent(from) == findParent(to))
                continue;
            
            answer += cost[2];
            
            parent[findParent(to)] = findParent(from);
        }
        
        return answer;
    }
}