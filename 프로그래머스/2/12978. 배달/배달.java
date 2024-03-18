import java.util.Arrays;

class Solution {
    
    private static final Integer START_NODE = 1;
    
    private int[][] nodeList;
    
    private boolean[] visited;
    
    private int[] result;
    
    private int N;
    
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.nodeList = new int[N][N];
        this.visited = new boolean[N];
        visited[0] = true;
        
        for (int[] eachRoad : road) {
            updateNode(eachRoad);
        }
        
        this.result = nodeList[0];
        int next = nextIndex();
        
        while (next != -1) {
            dijkstra(next);
            next = nextIndex();
        }
        
        return (int) Arrays.stream(result)
            .filter(v -> v <= K)
            .count();
    }
    
    private void dijkstra(int index) {
        int cost = result[index];
        int[] nodes = nodeList[index];
        
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 0 || visited[i]) {
                continue;
            }
                
            if (result[i] == 0 || nodes[i] + cost < result[i]) {
                result[i] = nodes[i] + cost;
            }
        }
        
        visited[index] = true;
    }
    
    private void updateNode(int[] node) {
        int a = node[0] - 1;
        int b = node[1] - 1;
        int c = node[2];
        
        if (nodeList[a][b] == 0 || nodeList[a][b] > c) {
            nodeList[a][b] = c;
        }
        
        if (nodeList[b][a] == 0 || nodeList[b][a] > c) {
            nodeList[b][a] = c;
        }
    }
    
    private int nextIndex() {
        int minIndex = -1;
        int minValue = -1;
        
        for (int index = 1; index < N; index++) {
            if (visited[index] || result[index] == 0) {
                continue;
            }
            
            if (minValue == -1 || minValue > result[index]) {
                minIndex = index;
                minValue = result[index];
            }
        }
        
        return minIndex;
    }
    
}