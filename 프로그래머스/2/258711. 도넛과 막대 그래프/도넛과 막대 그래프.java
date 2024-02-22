import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, Set<Integer>> node = new HashMap<>();
        Set<Integer> back = new HashSet<>();
        
        for(int[] edge : edges) {
            Set<Integer> nextNodes = node.getOrDefault(edge[0], new HashSet<>());
            nextNodes.add(edge[1]);
            node.put(edge[0], nextNodes);
            back.add(edge[1]);
        }
        
        for(int i : node.keySet()) {
            if(!back.contains(i) && node.getOrDefault(i, new HashSet<>()).size() > 1) {
                answer[0] = i;
                break;
            }  
        }
        
        Set<Integer> answerNode = node.get(answer[0]);
        
        for(int next : answerNode) {
            int now = -1;
            Set<Integer> o = node.getOrDefault(next, new HashSet<>());
            
            while(true) {     
                if(o.size() == 0) {
                    answer[2]++;
                    break;
                }
                
                if(o.size() > 1) {
                    answer[3]++;
                    break;
                }
                
                if(next == now) {
                    answer[1]++;
                    break;
                }
                
                
                for(int i : o) {
                    now = i;
                    o = node.getOrDefault(i, new HashSet<>());
                    break;
                }
            }
        }
        
        return answer;
    }
}