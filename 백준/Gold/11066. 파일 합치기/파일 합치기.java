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
        for (int i = 0; i < n; i++) {
            int number = getInt(br);
            int[] numberArray = getNumberArray(br);
            if (i > 0) {
                bw.write("\n");
            }

            bw.write("" + dp(number, numberArray));
        }

        br.close();
        bw.close();
    }

    private static int dp(int number, int[] numberArray) {
        int[][] dp = new int[number + 1][number + 1];

        int[] sum = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            sum[i] = sum[i - 1] + numberArray[i - 1];
        }

        for (int count = 2; count <= number; count++) {                 // 몇 개를 합칠지
            for (int from = 1; from <= number - count + 1; from++) {    // 특정 아이템에서 시작
                int to = from + count - 1;
                dp[from][to] = Integer.MAX_VALUE;

                for (int mid = from; mid < to; mid++) {                 // 가운데 나누기
                    dp[from][to] = Math.min(dp[from][to], dp[from][mid] + dp[mid + 1][to] + sum[to] - sum[from - 1]);
                }
            }
        }

        return dp[1][number];   // 1부터 number까지 값
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
