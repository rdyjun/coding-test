import java.util.*;
import java.util.regex.Pattern;

class Solution {
    private int userLen;
    private int bannedLen;
    private ArrayList<ArrayList<Integer>> MatchingData = new ArrayList<>();
    private Set<String> answer = new HashSet<>();
    
    private void internalDfs (int n, int i, int[] visited) {
        if (visited[i] == 0)
            dfs(n, i, visited.clone());
    }
    
    /** banned_id의 0 ~ 마지막 인덱스를 순회하면서 각 자리에 들어갈 수 있는 경우의 수 탐색 */
    private void dfs (int n, int node, int[] visited) {
        visited[node] = 1;
        
        if (n == bannedLen - 1) {
            answer.add(Arrays.toString(visited));
            return;
        }
        
        for (int i : MatchingData.get(n + 1))
            internalDfs(n + 1, i, visited);
    }
    
    /** [분리함수 - 1_2] 두 문자를 비교하여, MatchingData 에 추가 */
    private void addByCompare (int compareIndex, int same, String st1, String st2) {
        if (Pattern.matches(st1, st2))
            MatchingData.get(compareIndex).add(same);
    }
    
    /** [분리함수 - 1_1] 각 user_id를 불러와서 비교 함수 호출 */
    private void addCase (String st, int i, String[] banned_id, String[] user_id) {
        for (int k = 0; k < userLen; k++)
            addByCompare(i, k, st, user_id[k]);
    }
    
    /** [dfs 준비물 - 1] 각 banned_id 요소 별 들어갈 수 있는 user_id의 index를 담은 2중 배열 구성(MatchingData) */
    private void createMatchingData (String[] banned_id, String[] user_id) {
        for (int i = 0; i < bannedLen; i++) {
            String st = banned_id[i].replaceAll("\\*", ".");
            MatchingData.add(new ArrayList<>());
            addCase(st, i, banned_id, user_id);
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        userLen = user_id.length;
        bannedLen = banned_id.length;
        createMatchingData(banned_id, user_id);
        
        for (int i : MatchingData.get(0))
            dfs(0, i, new int[userLen]); // 0 1
        return answer.size();
    }
}