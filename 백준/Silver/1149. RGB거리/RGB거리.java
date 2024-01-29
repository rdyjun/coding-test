import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int[][] dp = new int[n][3]; // 0:R, 1:G, 2:B

        // 값 받아기
        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");
            dp[i][0] = Integer.parseInt(input[0]);
            dp[i][1] = Integer.parseInt(input[1]);
            dp[i][2] = Integer.parseInt(input[2]);
        }

        // 점화식
        for(int i = 1; i < n; i++) {
            dp[i][0] += Integer.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += Integer.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += Integer.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int min = Integer.min(Integer.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);

        IO.write(String.valueOf(min));
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