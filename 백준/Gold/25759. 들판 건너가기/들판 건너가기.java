import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		String[] input = reader.readLine().split(" ");

		int[] dp = new int[100];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[Integer.parseInt(input[0]) - 1] = 0;

		for (int i = 1; i < n; i++) {
			int nowFlower = Integer.parseInt(input[i]);

			for (int k = 0; k < 100; k++) {
				if (dp[k] >= 0) {
					int tmpDistance = nowFlower - (k + 1);
					tmpDistance *= tmpDistance;
					tmpDistance += dp[k];

					dp[nowFlower - 1] = Math.max(tmpDistance, dp[nowFlower - 1]);
				}
			}
		}

		int answer = Arrays.stream(dp)
				.max()
				.orElse(-1);

		writer.write(String.valueOf(answer));

		writer.flush();
		writer.close();
		reader.close();
    }

}
