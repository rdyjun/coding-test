import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] dp = new int[k][n + 1];

        // 1장으로 만들 수 있는 각 숫자들 - 무조건 1
        for(int col = 0; col < n + 1; col++)
            dp[0][col] = 1;

        // 0을만들 수 있는 방법 - 무조건 1
        for(int row = 0; row < k; row++)
            dp[row][0] = 1;

        for(int row = 1; row < k; row++)
            for(int col = 1; col < n + 1; col++)
                dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) % 1000000000;

        IO.write(String.valueOf(dp[k - 1][n]));
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

    public static void write(String message) throws IOException {
        bw.write(message);
    }
}