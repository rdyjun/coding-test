import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int verticesCount;

    private static int edgeCount;

    private static int startVertices;

    public static void main(String[] args) {
        IO.init();
        findMinCostOfNode();
        IO.close();
    }

    private static void findMinCostOfNode() {
        StringTokenizer input = new StringTokenizer(IO.read(), " ");
        verticesCount = Integer.parseInt(input.nextToken());
        edgeCount = Integer.parseInt(input.nextToken());

        startVertices = Integer.parseInt(IO.read());
        Map<Integer, List<Node>> graph = initializeGraph();

        int[] answer = dijkstra(graph);
        printAnswer(answer);
    }

    private static void printAnswer(int[] answer) {
        for (int index = 0; index < verticesCount; index++) {
            if (answer[index] == Integer.MAX_VALUE) {
                IO.write("INF\n");
                continue;
            }

            IO.write(answer[index] + "\n");
        }
    }

    private static int[] dijkstra(Map<Integer, List<Node>> graph) {
        int[] nodeCost = new int[verticesCount];
        Arrays.fill(nodeCost, Integer.MAX_VALUE);
        nodeCost[startVertices - 1] = 0;
        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(startVertices, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            visited.add(now.getNode());

            List<Node> nodes = graph.getOrDefault(now.getNode(), new ArrayList<>());
            if (!nodes.isEmpty()) {
                updateNodeCost(nodeCost[now.getNode() - 1], nodeCost, nodes, visited, pq);
            }
        }

        return nodeCost;
    }

    private static void updateNodeCost(int cost, int[] nodeCost, List<Node> nextNodeCost, Set<Integer> visited, PriorityQueue<Node> pq) {
		for (Node node : nextNodeCost) {
			if (visited.contains(
                    node.getNode())) {
				continue;
			}

			if (nodeCost[node.getNode() - 1] == Integer.MAX_VALUE
                    || node.getWeight() + cost < nodeCost[node.getNode() - 1]) {
                pq.add(new Node(node.getNode(), node.getWeight() + cost));
				nodeCost[node.getNode() - 1] = node.getWeight() + cost;
			}
		}
    }

    private static Map<Integer, List<Node>> initializeGraph() {
        Map<Integer, Map<Integer, Integer>> valueCheck = new HashMap<>();
        Map<Integer, List<Node>> graph = new HashMap<>();

        while (edgeCount-- > 0) {
            StringTokenizer input = new StringTokenizer(IO.read(), " ");
            int a = Integer.parseInt(input.nextToken());
            int b = Integer.parseInt(input.nextToken());
            int w = Integer.parseInt(input.nextToken());

            Map<Integer, Integer> vc = valueCheck.getOrDefault(a, new HashMap<>());
            int weight = vc.getOrDefault(b, -1);

            if (weight > -1 && weight <= w) {
                continue;
            }

            vc.put(b, w);
            valueCheck.put(a, vc);

            List<Node> arr = graph.getOrDefault(a, new ArrayList<>());
            arr.add(new Node(b, w));
            graph.put(a, arr);
        }

        return graph;
    }

}

class Node implements Comparable<Node> {

    private final Integer node;

    private final Integer weight;

    public Node(int node, int cost) {
        this.node = node;
        this.weight = cost;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }

    public Integer getNode() {
        return node;
    }

    public Integer getWeight() {
        return weight;
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
