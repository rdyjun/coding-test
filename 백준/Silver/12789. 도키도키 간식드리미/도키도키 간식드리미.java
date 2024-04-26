import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		String[] input = reader.readLine()
				.split(" ");
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int now = 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (!stack.isEmpty() &&
			stack.peek() == now) {
				stack.pop();
				now++;
				i--;
				continue;
			}

			if (arr[i] == now) {
				now++;
				continue;
			}

			stack.add(arr[i]);
		}

		String answer = "Nice";

		while (!stack.isEmpty()) {
			int num = stack.pop();

			if (now != num) {
				answer = "Sad";
				break;
			}

			now++;
		}

		writer.write(answer);

		writer.flush();
		writer.close();
		reader.close();
    }

}
