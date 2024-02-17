import java.io.*;

public class Main {

    private static int n;

    private static int answer = 0;

    private static int[] board;

    public static void main(String[] args) throws Exception {
        IO.init();

        String input = IO.read();
        n = Integer.parseInt(input);
        board = new int[n];

        dfs(-1);

        IO.write(String.valueOf(answer));

        IO.close();
    }
    private static void dfs(int c) {
        if(c == n - 1) {
            answer++;
            return;
        }

        c++;

        for (int i = 0; i < n; i++) {
            board[c] = i;

            if(!promising(c))
                continue;

            dfs(c);
        }
    }
    private static boolean promising(int y) {
        for(int i = 0; i < y; i++) {
            if(board[i] == board[y] || y - i == Math.abs(board[i] - board[y]))
                return false;
        }

        return true;
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