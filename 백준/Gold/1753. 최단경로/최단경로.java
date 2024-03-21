import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int verticesCount;

    private static int edgeCount;

    private static int startVertices;

    private static List<List<Node>> graph;

    private static int[] distance;

    private static PriorityQueue<Node> priorityQueue;

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

        initializeGraph();
        initializeDistance();

        dijkstra();
        printAnswer();
    }

    private static void printAnswer() {
        for (int index = 0; index < verticesCount; index++) {
            if (distance[index] == Integer.MAX_VALUE) {
                IO.write("INF\n");
                continue;
            }

            IO.write(distance[index] + "\n");
        }
    }

    private static void dijkstra() {
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startVertices - 1, 0));

        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();

            updateNodeCost(now);
        }
    }

    private static void updateNodeCost(Node now) {
        List<Node> nextNodes = graph.get(now.getNode());
        int weight = now.getWeight();

		for (Node node : nextNodes) {
            int nodeNum = node.getNode();
            int sum = node.getWeight() + weight;

			if (distance[nodeNum] == Integer.MAX_VALUE
                    || sum < distance[nodeNum]) {
                priorityQueue.add(new Node(nodeNum, sum));
                distance[nodeNum] = sum;
			}
		}
    }

    private static void initializeDistance() {
        distance = new int[verticesCount];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertices - 1] = 0;
    }

    private static void initializeGraph() {
        graph = new ArrayList<>();
        for (int i = 0; i < verticesCount; i++) {
            graph.add(new ArrayList<>());
        }

        while (edgeCount-- > 0) {
            StringTokenizer input = new StringTokenizer(IO.read(), " ");

            int a = Integer.parseInt(input.nextToken()) - 1;
            int b = Integer.parseInt(input.nextToken()) - 1;
            int w = Integer.parseInt(input.nextToken());

            List<Node> arr = graph.get(a);
            arr.add(new Node(b, w));
            graph.set(a, arr);
        }
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
