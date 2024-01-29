import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");
            for(int k = i; k > 0; k--) {
                if(dp[k - 1] > dp[k]) {
                    dp[k] = dp[k - 1] + Integer.parseInt(input[k]);
                    continue;
                }
                dp[k] = dp[k] + Integer.parseInt(input[k]);;
            }
            dp[0] += Integer.parseInt(input[0]);
        }

        int max = 0;

        for(int i = 0; i < n; i++) {
            if(dp[i] > max)
                max = dp[i];
        }

        IO.write(String.valueOf(max));
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