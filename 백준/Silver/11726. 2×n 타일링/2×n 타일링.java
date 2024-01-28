import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int n = Integer.parseInt(input);
        int[] dp = new int[n];
        int sum = 1;

        dp[0] = sum;
        if(n >= 2) {
            sum += 1;
            dp[1] = sum;
        }

        for(int i = 2; i < n; i++){
            sum += dp[i - 2];
            sum %= 10007;
            dp[i] = sum;
        }

        IO.write(String.valueOf(dp[n - 1]));

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