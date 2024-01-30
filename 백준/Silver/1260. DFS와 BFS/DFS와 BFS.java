import java.io.*;
import java.util.*;

public class Main {
    private static Map<Integer, List<Integer>> map;
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            input = IO.read().split(" ");
            updateNode(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        int[] dfs = dfs(v);
        int[] bfs = bfs(v);

        for(int i : dfs)
            IO.write(i + " ");

        IO.write("\n");

        for(int i : bfs)
            IO.write(i + " ");

        IO.close();
    }
    private static void updateNode(int n, int m) {
        List<Integer> nArr = map.getOrDefault(n,  new ArrayList<>());
        List<Integer> mArr = map.getOrDefault(m,  new ArrayList<>());

        nArr.add(m);
        mArr.add(n);

        map.put(n, nArr);
        map.put(m, mArr);
    }
    private static int[] bfs(int start) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int now = q.poll();

            if(visited.getOrDefault(now - 1, false))
                continue;
            visited.put(now - 1, true);

            result.add(now);

            List<Integer> arr = map.getOrDefault(now, new ArrayList<>());
            Collections.sort(arr);
            for(int i : arr)
                q.add(i);
        }

        return result.stream()
                .mapToInt(v -> v)
                .toArray();
    }
    private static int[] dfs(int start) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(start);

        while(!stk.isEmpty()) {
            int now = stk.pop();

            if(visited.getOrDefault(now - 1, false))
                continue;
            visited.put(now - 1, true);

            result.add(now);

            List<Integer> arr = map.getOrDefault(now, new ArrayList<>());
            Collections.sort(arr, Collections.reverseOrder());

            for(int i : arr)
                stk.push(i);
        }

        return result.stream()
                .mapToInt(v -> v)
                .toArray();
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
    public static void write(String message) throws IOException {
        bw.write(message);
    }
}