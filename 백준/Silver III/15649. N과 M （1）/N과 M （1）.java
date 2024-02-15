import java.io.*;

public class Main {

    private static int n;

    private static int m;

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        dfs(0, new int[m], new boolean[n]);

        IO.close();
    }
    private static void dfs(int count, int[] arr, boolean[] visited) throws IOException {
        if(count == m) {
            printArray(arr);
            return;
        }

        count++;

        for(int i = 0; i < n; i++) {
            if(visited[i])
                continue;

            boolean[] newVisited = visited.clone();
            newVisited[i] = true;

            arr[count - 1] = i + 1;
            dfs(count, arr, newVisited);
        }
    }
    private static void printArray(int[] arr) throws IOException {
        for(int i : arr)
            IO.write(i + " ");

        IO.write("\n");
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