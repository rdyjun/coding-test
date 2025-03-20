import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = getInt(br);
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = getInt(br);
        }

        int answer = 0;
        int[] dp = new int[n + 1];
        if (n >= 1) {
            dp[1] = array[1];
            answer = array[1];
        }
        if (n >= 2) {
            dp[2] = array[1] + array[2];
            answer = Math.max(answer, dp[2]);
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(array[i] + array[i - 1] + dp[i - 3], array[i] + dp[i - 2]));
            answer = Math.max(answer, dp[i]);
        }

        bw.write(answer + "");

        br.close();
        bw.close();
    }

    private static int getInt(BufferedReader br) throws IOException {
        String input = br.readLine();
        return Integer.parseInt(input);
    }

}
