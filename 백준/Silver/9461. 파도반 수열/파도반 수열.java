import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int n = Integer.parseInt(input);
        int[] arr = new int[n];

        int max = 0;

        for(int i = 0; i < n; i++) {
            input = IO.read();
            arr[i] = Integer.parseInt(input);

            if(arr[i] > max)
                max = arr[i];
        }

        long[] dp = new long[max + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 0;

        for(int i = 3; i < max + 3; i++)
            dp[i] = dp[i - 2] + dp[i - 3];

        for(int i = 0; i < arr.length - 1; i++)
            IO.write(dp[arr[i] + 2] + "\n");
        IO.write(String.valueOf(dp[arr[n - 1] + 2]));

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