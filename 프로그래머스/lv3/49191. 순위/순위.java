import java.util.*;

class Solution {
    ArrayList<HashSet<Integer>> topNode = new ArrayList<>(); // 방문 가능한 상위 노드
    ArrayList<HashSet<Integer>> underNode = new ArrayList<>(); // 방문 가능한 하위 노드
    
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> type = new LinkedList<>(); // 0 이면 아래 1이면 위
    
    public void adjacentNode (int[][] results) {
        for (int[] i : results) { // 각 노드별 갈 수 있는 노드 추가
            underNode.get(i[0] - 1).add(i[1] - 1);
            topNode.get(i[1] - 1).add(i[0] - 1);
        }
    }
    
    public void extendsArray (ArrayList<HashSet<Integer>> arr, int n) {
        for (int i = 0; i < n; i++)
            arr.add(new HashSet<>());
    }
    
    public void nodeSearch (int nodeType, int n) {
        HashSet<Integer> tmp = new HashSet<>();
        if (nodeType == -1) {
            nodeSearch(0, n);
            nodeSearch(1, n);
            return;
        }
        
        if (nodeType == 0)
            tmp = underNode.get(n);
        if (nodeType == 1)
            tmp = topNode.get(n);
        
        for (int k : tmp) {
            q.add(k);
            type.add(nodeType);
        }
        
    }
    
    public int solution(int n, int[][] results) {
        boolean[] visited = new boolean[n]; // 방문한 노드
        int answer = 0;
        
        extendsArray(topNode, n);
        extendsArray(underNode, n);
        adjacentNode(results);
        
        int c = 0;
        for (int i = 0; i < n; i++) {
            q.add(i);
            type.add(-1);
            while (!q.isEmpty()) {
                int qValue = q.poll();
                int nodeType = type.poll();
                if (visited[qValue])
                    continue;
                visited[qValue] = true;
                
                c++;
                nodeSearch(nodeType, qValue);
            }
            if (c == n)
                answer++;
            c = 0;
            visited = new boolean[n];
        }
        return answer;
    }
}