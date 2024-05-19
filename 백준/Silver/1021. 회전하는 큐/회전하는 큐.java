import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine()
				.split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			deque.add(i);
		}

		Queue<Integer> outputQueue = new LinkedList<>();

		input = reader.readLine()
						.split(" ");

		for (String outputValue : input) {
			outputQueue.add(Integer.valueOf(outputValue));
		}

		int count = 0;

		while (!outputQueue.isEmpty()) {
			int output = outputQueue.poll();

			List<Integer> arr = new ArrayList<>(deque);
			int index = arr.indexOf(output);

			int left = index;
			int right = deque.size() - index;

			if (left == right ||
					left > right) {
				moveRight(index, arr);
				count += right;
			}

			if (right > left) {
				moveLeft(index, arr);
				count += left;
			}

			deque = new LinkedList<>(arr);
			deque.poll();
		}

		writer.write(count + "");

		writer.flush();
		writer.close();
		reader.close();
    }

	private static void moveRight(int index, List<Integer> arr) {
		List<Integer> subList = new ArrayList<>(arr.subList(index, arr.size()));
		arr.removeAll(subList);
		arr.addAll(0, subList);
	}

	private static void moveLeft(int index, List<Integer> arr) {
		List<Integer> subList = new ArrayList<>(arr.subList(0, index));
		arr.removeAll(subList);
		arr.addAll(subList);
	}

}
