import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        int n = Integer.parseInt(IO.read());
        if(n < 2) {
            IO.write(IO.read());
            IO.close();
            return;
        }

        int[] arr = new int[n];
        int[][] dp = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(IO.read());
            dp[i][0] = arr[i];
        }

        dp[0][1] = dp[0][0];
        dp[1][1] = dp[1][0] + dp[0][0];
        int answer = dp[1][1];

        for(int i = 2; i < n; i++) {
            dp[i][1] = dp[i][0] + dp[i - 1][0];

            if(dp[i - 2][1] >= dp[i - 2][0])
                dp[i][0] += dp[i - 2][1];
            if(dp[i - 2][1] < dp[i - 2][0])
                dp[i][0] += dp[i - 2][0];
        }

        if(dp[n - 1][0] >= dp[n - 1][1])
            answer = dp[n - 1][0];
        if(dp[n - 1][0] < dp[n - 1][1])
            answer = dp[n - 1][1];

        IO.write(String.valueOf(answer));
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