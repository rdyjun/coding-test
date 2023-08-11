import java.util.*;

class Solution {
    HashSet<Integer> arr = new HashSet<>();
    public void dfs (int s, int sheep, int wolf, int[] info, int[][] edges, boolean[] visited) {
        visited[s] = true;
        if (info[s] == 0)
            sheep++;
        if (info[s] == 1)
            wolf++;
        if (wolf >= sheep)
            return;
        
        for (int[] i : edges)
            if (visited[i[0]] && !visited[i[1]])
                dfs(i[1], sheep, wolf, info, edges, visited.clone());
        arr.add(sheep);
    }
    
    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        
        dfs(0, 0, 0, info, edges, visited.clone());
        int max = 0;
        for (int i : arr)
            if (max < i)
                max = i;
        return max;
    }
}