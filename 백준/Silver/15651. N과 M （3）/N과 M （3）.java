import java.io.*;

public class Main {

    private static int n;

    private static int m;

    private static int[] board;

    public static void main(String[] args) throws Exception {
        IO.init();

        String[] input = IO.read().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[m];

        dfs(-1);

        IO.close();
    }

    private static void dfs(int c) throws IOException {
        if(c == m - 1) {
            print();
            return;
        }

        c++;

        for(int i = 1; i <= n; i++) {
            board[c] = i;
            dfs(c);
        }
    }

    private static void print() throws IOException {
        for(int i : board)
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