import java.util.*;

class Solution {
    
    private String[] answer;
    
    private static final String START = "ICN";
    
    private Integer ticketCount;
    
    public String[] solution(String[][] tickets) {
        this.ticketCount = tickets.length;
        Map<String, PriorityQueue<String>> nodeMap = new HashMap<>();
        
        for (int i = 0; i < ticketCount; i++) {
            PriorityQueue<String> childNodes = nodeMap.getOrDefault(tickets[i][0], new PriorityQueue<>());
            childNodes.add(tickets[i][1]);
            nodeMap.put(tickets[i][0], childNodes);
        }
        
        List<String> nodeList = new ArrayList<>();
        nodeList.add(START);
        
        return dfs(START, nodeMap, nodeList).stream()
            .toArray(String[]::new);
    }
    
    private List<String> dfs(String now, Map<String, PriorityQueue<String>> nodeMap, List<String> nodeList) {
        PriorityQueue<String> nextNodes = new PriorityQueue<>(nodeMap.getOrDefault(now, new PriorityQueue<>()));
        
        while (!nextNodes.isEmpty()) {
            String next = nextNodes.poll();
            
            Map<String, PriorityQueue<String>> tmpNodeMap = new HashMap<>(nodeMap);
            PriorityQueue<String> tmpNextNodes = new PriorityQueue<>(tmpNodeMap.get(now));
            tmpNextNodes.remove(next);
            tmpNodeMap.put(now, tmpNextNodes);
            
            List<String> tmpNodeList = new ArrayList<>(nodeList);
            tmpNodeList.add(next);
            
            List<String> result = dfs(next, tmpNodeMap, tmpNodeList);
            
            if (result.size() - 1 == ticketCount) {
                return result;
            }
        }
        return nodeList;
    }
}