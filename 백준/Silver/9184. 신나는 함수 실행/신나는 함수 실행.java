import java.io.*;

public class Main {

    private static int[][][] dp;

    public static void main(String[] args) throws Exception {
        IO.init();

        String[] input = IO.read().split(" ");
        int a, b, c;

        while(!isEnd(input)) {
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);

            dp = null;

            IO.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");

            input = IO.read().split(" ");
        }

        IO.close();
    }

    private static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;

        if(a > 20 || b > 20 || c > 20) {
            dp = new int[21][21][21];
            return w(20, 20, 20);
        }

        if(dp == null)
            dp = new int[a + 1][b + 1][c + 1];

        if(a < b && b < c) {
            dp[a][b][c] = calc1(a, b, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = calc2(a, b, c);
        return dp[a][b][c];
    }

    private static int calc1(int a, int b, int c) {
        int result = 0;

        result += dp[a][b][c - 1];
        if(dp[a][b][c - 1] == 0)
            result += w(a, b, c - 1);

        result += dp[a][b - 1][c - 1];
        if(dp[a][b - 1][c - 1] == 0)
            result += w(a, b - 1, c - 1);

        result -= dp[a][b - 1][c];
        if(dp[a][b - 1][c] == 0)
            result -= w(a, b - 1, c);

        return result;
    }

    private static int calc2(int a, int b, int c) {
        int result = 0;

        result += dp[a - 1][b][c];
        if(dp[a - 1][b][c] == 0)
            result += w(a - 1, b, c);

        result += dp[a - 1][b - 1][c];
        if(dp[a - 1][b - 1][c] == 0)
            result += w(a - 1, b - 1, c);

        result += dp[a - 1][b][c - 1];
        if(dp[a - 1][b][c - 1] == 0)
            result += w(a - 1, b, c - 1);

        result -= dp[a - 1][b - 1][c - 1];
        if(dp[a - 1][b - 1][c - 1] == 0)
            result -= w(a - 1, b - 1, c - 1);

        return result;
    }

    private static boolean isEnd(String[] input) {
        for(String st : input)
            if(!st.equals("-1"))
                return false;

        return true;
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