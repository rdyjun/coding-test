import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Main{
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[nodeA][nodeB] = value;
            graph[nodeB][nodeA] = value;

            // 위 노드 외 다른 노드와 연결되어있다면 업데이트
            for (int nodeC = 1; nodeC <= n; nodeC++) {
                if (nodeA != nodeC) {
                    // A->C로가는 비용은 A->B와 B->C 중 비용이 낮은 걸로 저장 (하지만 기존 값이 있는 경우 큰 값으로 저장)
                    graph[nodeA][nodeC] = Math.max(graph[nodeA][nodeC], Math.min(graph[nodeA][nodeB], graph[nodeB][nodeC]));
                    graph[nodeC][nodeA] = graph[nodeA][nodeC];
                }

                if (nodeB != nodeC) {
                    graph[nodeB][nodeC] = Math.max(graph[nodeB][nodeC], Math.min(graph[nodeA][nodeB], graph[nodeA][nodeC]));
                    graph[nodeC][nodeB] = graph[nodeB][nodeC];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int sum = Arrays.stream(graph[target])
                    .filter((node) -> node >= k)
                    .boxed()
                    .collect(Collectors.toList())
                    .size();
            
            System.out.println(sum);
        }
    }
}
