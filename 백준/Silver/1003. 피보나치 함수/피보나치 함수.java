import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int max = Integer.MIN_VALUE;
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());

			if (max == Integer.MIN_VALUE || arr[i] > max) {
				max = arr[i];
			}
		}

		int[] dp = new int[max + 2];
		dp[0] = 1;
		dp[1] = 0;

		for (int i = 2; i <= max + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		for (int i = 0; i < n; i++) {
			writer.write(dp[arr[i]] + " " + dp[arr[i] + 1]);

			if (i != n - 1) {
				writer.write("\n");
			}
		}

		writer.flush();
		writer.close();
		reader.close();
    }

}
