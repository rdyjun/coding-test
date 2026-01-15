import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 각 노드간 거리
        int[][] graph = new int[n + 1][n + 1];
        
        // fares에서 각 시작-종료 지점에 cost 저장
        for (int r = 0; r < fares.length; r++) {
            graph[fares[r][0]][fares[r][1]] = fares[r][2];
            graph[fares[r][1]][fares[r][0]] = fares[r][2];
        }
        
        int[] resultA = dijkstra(a, s, n, a, b, graph);
        int[] resultB = dijkstra(b, s, n, a, b, graph);
        int[] resultS = dijkstra(s, s, n, a, b, graph);
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, resultA[i] + resultB[i] + resultS[i]);
        }
        
        return min;
    }
    
    private int[] dijkstra(int start, int s, int n, int a, int b, int[][] graph) {
        int[] dist = new int[n + 1];
        
        // [... INF, 0, INF, INF ...]
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        // 다익스트라 배열 초기화
        PriorityQueue<Integer[]> pq = // [0]: 비용 [1]: 위치
                new PriorityQueue<>((aa, bb) -> Integer.compare(aa[0], bb[0])); // 비용으로 우선순위 정하기
        pq.offer(new Integer[]{0, start}); // start 위치 저장
        
        while (!pq.isEmpty()) {
            Integer[] cur = pq.poll();
            
            int now = cur[1]; // 현재 위치
            int cost = cur[0];
            
            if (dist[now] < cost) {
                continue;
            }
            
            // now가 갈 수 있는 다음 노드들 업데이트
            for (int next = 1; next <= n; next++) {
                // 갈 수 있으면서 현재 방문 가능한 노드보다 적은 코스트인 경우
                if (graph[now][next] != 0 // now 노드가 next노드를 갈 수 있는가
                    && dist[next] > dist[now] + graph[now][next]) { // dist에 저장된 next 값이 now에 가는 값 + now에서 next가는 값보다 작은가
                    dist[next] = dist[now] + graph[now][next];
                    pq.offer(new Integer[]{dist[next], next});
                }
            }
        }
        
        return dist;
    }
}