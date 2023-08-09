import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        q.add(0);
        c.add(0);
        
        int node, nodeNum;
        boolean[] visited = new boolean[n];
        int max = -1;
        int answer = 0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int[] i : edge) {
            int a = i[0] - 1;
            int b = i[1] - 1;
            int m = a > b ? a : b;
            for (int k = arr.size() - 1; k <= m; k++)
                arr.add(new ArrayList<>());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        while (!q.isEmpty()) {
            node = q.poll();
            nodeNum = c.poll();
            if (visited[node])
                continue; 
            visited[node] = true;
            for (int i = 0; i < arr.get(node).size(); i++) {
                q.add(arr.get(node).get(i));
                c.add(nodeNum + 1);
            }
            if (max == -1 || max < nodeNum) {
                
                max = nodeNum;
                answer = 1;
                continue;
            }
            if (max == nodeNum)
                answer++;
        }
        
        return answer;
    }
}