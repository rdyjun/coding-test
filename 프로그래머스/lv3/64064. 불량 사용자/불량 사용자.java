import java.util.*;
import java.util.regex.Pattern;

class Solution {
    private int userLen;
    private int bannedLen;
    private ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    private HashSet<String> answer = new HashSet<>();
    
    private void dfs (int n, int node, int[] visited) {
        visited[node] = 1;
        
        if (n == bannedLen - 1) {
            answer.add(Arrays.toString(visited));
            return;
        }
            
        
        
        for (int i : arr.get(n + 1)) {
            if (visited[i] == 0)
                dfs(n + 1, i, visited.clone());
        }
    }
    
    private void addByCompare (int compareIndex, int same, String st1, String st2) {
        if (Pattern.matches(st1, st2))
            arr.get(compareIndex).add(same);
    }
    
    private void addCase (int i, String[] banned_id, String[] user_id) {
        for (int k = 0; k < userLen; k++) {
            String st = banned_id[i].replaceAll("\\*", ".");
            addByCompare(i, k, st, user_id[k]);
        }
    }
    
    private void createAllCases (String[] banned_id, String[] user_id) {
        for (int i = 0; i < bannedLen; i++) {
            arr.add(new ArrayList<>());
            addCase(i, banned_id, user_id);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        userLen = user_id.length;
        bannedLen = banned_id.length;
        createAllCases (banned_id, user_id);
        
        for (int i : arr.get(0))
            dfs(0, i, new int[userLen]); // 0 1
        return answer.size();
    }
}