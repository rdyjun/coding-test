import java.util.*;

class Solution {
    private void changeTeam (int[] team, int prev, int next) {
        for (int i = 0; i < team.length; i++)
            if (team[i] == prev)
                team[i] = next;
    }
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (v1, v2) -> Integer.compare(v1[2], v2[2]));
        int[] team = new int[n];
        int c = 0;
        int answer = 0;
        int from, to, cost;
        
        for (int i = 0; i < costs.length; i++) {
            from = costs[i][0];
            to = costs[i][1];
            cost = costs[i][2];
            
            if (team[from] != 0 && team[from] == team[to])
                continue;
            
            answer += cost;
            
            if (team[from] == 0) {
                team[from] = ++c;
                if (team[to] == 0)
                    team[to] = c;
                else
                    changeTeam(team, team[to], team[from]);
                continue;
            }
            
            if (team[to] == 0) {
                team[to] = team[from];
                continue;
            }
            changeTeam(team, team[to], team[from]);
        }
        
        return answer;
    }
}