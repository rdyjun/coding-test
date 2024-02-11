import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int n = Integer.parseInt(input);

        int[][] dp = new int[n + 1][10];

        for(int col = 0; col < 10; col++)
            dp[0][col] = 1;

        for(int row = 1; row < n + 1; row++)
            for(int col = 0; col < 10; col++)
                for(int prevCol = 0; prevCol <= col; prevCol++) {
                    dp[row][col] += dp[row - 1][prevCol];
                    dp[row][col] %= 10007;
                }

        IO.write(String.valueOf(dp[n][9]));

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