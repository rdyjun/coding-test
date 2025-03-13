import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        final int MOD = 987654321;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 2; i <= n; i += 2) {
            for (int k = 0; k <= i - 2; k += 2) {
                dp[i] = (dp[i] + (dp[k] * dp[i - k - 2]) % MOD) % MOD;
            }
        }

        bw.write("" + dp[n] % MOD);

        br.close();
        bw.close();
    }

}
