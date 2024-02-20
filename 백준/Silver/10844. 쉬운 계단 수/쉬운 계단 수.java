import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int n = Integer.parseInt(input);

        long[][] dp = new long[n][10];
        dp[0][0] = 0;

        for(int i = 1; i < 10; i++)
            dp[0][i] = 1;

        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];

            for (int k = 1; k < 9; k++) {
                dp[i][k] = dp[i - 1][k - 1] + dp[i - 1][k + 1];
                dp[i][k] %= 1000000000;
            }
        }

        long answer = 0;

        for(int i = 0; i < 10; i++)
            answer += dp[n - 1][i];

        IO.write(String.valueOf(answer % 1000000000));

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