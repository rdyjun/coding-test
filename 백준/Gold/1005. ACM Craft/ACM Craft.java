import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        IO.init();
        getNextTotalCost();
        IO.close();
    }

    private static void getNextTotalCost() {
        int gameCount = Integer.parseInt(IO.read());

        for (int gameNumber = 0; gameNumber < gameCount; gameNumber++) {
            gameStart();
        }
    }

    private static void gameStart() {
        StringTokenizer input = new StringTokenizer(IO.read(), " ");
        int buildingCount = Integer.parseInt(input.nextToken()); // 건물 수 2 <= N <= 1000
        int routeCount = Integer.parseInt(input.nextToken()); // 경로 수 1 <= K <= 100000

        Map<Integer, Node> nodeMap = new HashMap<>(); // 각 노드의 자식 노드 및 비용를 담는 Hash Map

        input = new StringTokenizer(IO.read());
        int[] nodeCost = new int[buildingCount];
        int[] visitedCount = new int[buildingCount];

        /** 지역별 소요시간 */
        for (int nodeIndex = 0; nodeIndex < buildingCount; nodeIndex++) {
            int cost = Integer.parseInt(input.nextToken());

            nodeMap.put(nodeIndex + 1, new Node(cost));

            nodeCost[nodeIndex] = cost;
        }

        Set<Integer> childNodes = new HashSet<>();

        /** 자식 노드 */
        for (int routeIndex = 0; routeIndex < routeCount; routeIndex++) { // 각 경로를 map을 통해 추가
            input = new StringTokenizer(IO.read());
            int from = Integer.parseInt(input.nextToken());
            int to = Integer.parseInt(input.nextToken());

            Node node = nodeMap.get(from);
            node.addChildNode(to);

            nodeMap.put(from, node);

            childNodes.add(to);

            visitedCount[to - 1]++;
        }

        List<Integer> rootList = new ArrayList<>();
        // 루트 찾기
        for (int buildingIndex = 0; buildingIndex < buildingCount; buildingIndex++) {
            if (visitedCount[buildingIndex] == 0) {
                rootList.add(buildingIndex + 1);
            }
        }

        int destination = Integer.parseInt(IO.read());

        Queue<Integer> nodes = new LinkedList<>();
        boolean[] visited = new boolean[buildingCount];
        for (int root : rootList)
            nodes.add(root);

        while (!nodes.isEmpty()) {
            int now = nodes.poll();

            visited[now - 1] = true;

            Node node = nodeMap.get(now);
            Set<Integer> childs = node.getChildNodes();

            for (int child : childs) {
                if (visited[child - 1]) {
                    continue;
                }

                int nextCost = nodeCost[now - 1] + nodeMap.get(child)
                        .getcost();

                if (nodeCost[child - 1] < nextCost) {
                    nodeCost[child - 1] = nextCost;
                }

                visitedCount[child - 1]--;

                if (visitedCount[child - 1] == 0) {
                    nodes.add(child);
                }
            }
        }

        IO.write(nodeCost[destination - 1] + "\n");
    }

    static class Node {
        private int cost;
        private Set<Integer> nextNodes;

        public Node(int cost) {
            this.cost = cost;
            this.nextNodes = new HashSet<>();
        }

        public void addChildNode(int childNode) {
            this.nextNodes.add(childNode);
        }

        public Set<Integer> getChildNodes() {
            return this.nextNodes;
        }

        public int getcost() {
            return this.cost;
        }
    }
}

class IO {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() {
        try {
            writer.flush();
            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void write(Object message) {
        try {
            writer.write(String.valueOf(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

