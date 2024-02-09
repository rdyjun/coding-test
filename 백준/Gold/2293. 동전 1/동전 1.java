import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        int[] dp = new int[k + 1];

        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");
            arr[i] = Integer.parseInt(input[0]);
        }

        dp[0] = 1;
        for(int i = 0; i < n; i++)
            for(int j = arr[i]; j <= k; j++)
                dp[j] += dp[j - arr[i]];

        IO.write(String.valueOf(dp[k]));

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