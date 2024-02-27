import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        StringTokenizer input = new StringTokenizer(IO.read(), " ");
        int n = Integer.parseInt(input.nextToken());
        int m = Integer.parseInt(input.nextToken());

        int[][] dp = new int[n][n];
        int start, end, distance, now, count = 0;

        for(int i = 0; i < n - 1; i++) {
            input = new StringTokenizer(IO.read(), " ");
            start = Integer.parseInt(input.nextToken());
            end = Integer.parseInt(input.nextToken());
            distance = Integer.parseInt(input.nextToken());

            dp[start - 1][end - 1] = distance;
            dp[end - 1][start - 1] = distance;
        }

        boolean[] visited;
        Queue<Integer> q;
        Queue<Integer> c;

        for(int i = 0; i < m; i++) {
            input = new StringTokenizer(IO.read());
            start = Integer.parseInt(input.nextToken());
            end = Integer.parseInt(input.nextToken());

            if(dp[start - 1][end - 1] > 0) {
                IO.write(dp[start - 1][end - 1] + "\n");
                continue;
            }

            visited = new boolean[n];
            q = new LinkedList<>();
            c = new LinkedList<>();
            q.add(start - 1);
            c.add(0);

            while(!q.isEmpty()) {
                now = q.poll();
                count = c.poll();

                visited[now] = true;

                if(now == end - 1)
                    break;

                for(int k = 0; k < n; k++) {
                    if(visited[k] || dp[now][k] == 0)
                        continue;

                    q.add(k);
                    c.add(count + dp[now][k]);
                }
            }

            IO.write(count + "\n");
        }

        IO.close();
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