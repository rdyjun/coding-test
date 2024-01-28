import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int n = Integer.parseInt(input);

        int max = 0;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            input = IO.read();
            arr[i] = Integer.parseInt(input);
            if(arr[i] > max)
                max = arr[i];
        }

        int[] dp = new int[max];
        int sum = 1;

        for(int i = 0; i < 3; i++) {
            dp[i] = sum;
            sum += dp[i];
        }

        sum -= 1;
        if(3 < max)
            dp[3] = sum;

        for(int i = 4; i < max; i++) {
            sum += sum - dp[i - 4];
            dp[i] = sum;
        }

        for(int i = 0; i < n; i++) {
            IO.write(dp[arr[i] - 1] + "\n");
        }

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