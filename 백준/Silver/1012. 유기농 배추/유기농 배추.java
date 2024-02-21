import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int n;

    private static int m;

    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int t = Integer.parseInt(input);

        for(int i = 0; i < t; i++)
            IO.write(getAnswer() + "\n");

        IO.close();
    }

    private static int getAnswer() throws IOException {
        String[] input = IO.read().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        int[][] ground = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int answer = 0;

        for(int i = 0; i < k; i++) {
            input = IO.read().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            ground[y][x] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] || ground[i][j] == 0)
                    continue;

                checkVisited(ground, visited, j, i);
                answer++;
            }
        }

        return answer;
    }

    private static void checkVisited(int[][] ground, boolean[][] visited, int x, int y) {
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        xq.add(x);
        yq.add(y);

        while(!xq.isEmpty()) {
            x = xq.poll();
            y = yq.poll();

            if(visited[y][x] || ground[y][x] == 0)
                continue;

            visited[y][x] = true;

            if(x > 0) {
                xq.add(x - 1);
                yq.add(y);
            }

            if(x < m - 1) {
                xq.add(x + 1);
                yq.add(y);
            }

            if(y > 0) {
                xq.add(x);
                yq.add(y - 1);
            }

            if(y < n - 1) {
                xq.add(x);
                yq.add(y + 1);
            }
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