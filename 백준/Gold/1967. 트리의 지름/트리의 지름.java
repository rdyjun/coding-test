import java.io.*;
import java.util.*;

public class Main {

    private static int n;

    private static Map<Integer, List<Edge>> node;

    public static void main(String[] args) throws IOException {
        IO.init();

        n = Integer.parseInt(IO.read());

        StringTokenizer input;
        node = new HashMap<>();

        for(int i = 0; i < n - 1; i++) {
            input = new StringTokenizer(IO.read(), " ");
            int parent = Integer.parseInt(input.nextToken());
            int child = Integer.parseInt(input.nextToken());
            int cost = Integer.parseInt(input.nextToken());

            List<Edge> nodeListParent = node.getOrDefault(parent - 1, new ArrayList<>());
            nodeListParent.add(new Edge(child - 1, cost));
            node.put(parent - 1, nodeListParent);

            List<Edge> nodeListChild = node.getOrDefault(child - 1, new ArrayList<>());
            nodeListChild.add(new Edge(parent - 1, cost));
            node.put(child - 1, nodeListChild);
        }

        int[] next = farNode(0, 0, new boolean[n]);
        int[] answer = farNode(next[1], 0, new boolean[n]);

        IO.write(answer[0]);
        IO.close();
    }

    private static int[] farNode(int now, int cost, boolean[] visited) {
        if(visited[now])
            return new int[0];

        visited[now] = true;
        int[] result = new int[]{cost, now};

        List<Edge> nodeList = node.getOrDefault(now, new ArrayList<>());
        for(Edge next : nodeList) {
            int[] tmp = farNode(next.getTo(), cost + next.getCost(), visited);

            if(tmp.length > 0 && tmp[0] > result[0])
                result = tmp.clone();
        }

        return result;
    }

    static class Edge {

        private int to;

        private int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int getCost() {
            return this.cost;
        }

        public int getTo() {
            return this.to;
        }
    }
}

class IO {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    public static String read() throws IOException {
        return br.readLine();
    }

    public static void write(Object message) throws IOException {
        bw.write(String.valueOf(message));
    }
}