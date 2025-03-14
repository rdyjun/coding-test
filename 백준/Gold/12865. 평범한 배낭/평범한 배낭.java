import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] splitInput = input.split(" ");
        int n = Integer.parseInt(splitInput[0]);
        int k = Integer.parseInt(splitInput[1]);

        int[][] itemArray = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            input = br.readLine();
            splitInput = input.split(" ");
            int weight = Integer.parseInt(splitInput[0]);
            int value = Integer.parseInt(splitInput[1]);

            itemArray[i] = new int[]{weight, value};
        }

        int[][] dp = new int[n + 1][k + 1]; // 누가 무게는
        for (int i = 1; i <= n; i++) {       // 누구
            int weight = itemArray[i][0];
            int value = itemArray[i][1];

            for (int w = 1; w <= k; w++) {  // 무게
                if (weight > w) {
                    dp[i][w] = dp[i - 1][w];
                    continue;
                }

                int differenceValue = dp[i - 1][w - weight];
                dp[i][w] = Math.max(dp[i - 1][w], differenceValue + value);
            }
        }

        int answer = 0;
        for (int row = 1; row <= n; row++) {
            answer = Math.max(answer, dp[row][k]);
        }

        bw.write("" + answer);

        br.close();
        bw.close();
    }

}
