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
        int[] array = getNumberArray(br);
        int[] dp = new int[n + 1];
        dp[1] = array[0];

        int answer = array[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(array[i - 1], dp[i - 1] + array[i - 1]);
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

    private static int[] getNumberArray(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] split = input.split(" ");
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
