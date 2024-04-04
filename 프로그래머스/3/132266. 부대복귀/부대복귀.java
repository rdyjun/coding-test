import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

	private static final Integer CANT_VISITED_STATUS = Integer.MAX_VALUE;

	private List<List<Integer>> graph;

	private int[] distance;

	private int[] sources;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		this.graph = new ArrayList<>();
		this.sources = sources;

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] road : roads) {
			int a = road[0];
			int b = road[1];

			graph.get(a - 1).add(b);
			graph.get(b - 1).add(a);
		}

		distance = new int[n];
		Arrays.fill(distance, CANT_VISITED_STATUS);

		dijikstra(destination);

		return convert();
	}

	private int[] convert() {
		int sourceCount = sources.length;
		int[] result = new int[sourceCount];

		for (int i = 0; i < sourceCount; i++) {
			result[i] = this.distance[this.sources[i] - 1];

			if (result[i] == CANT_VISITED_STATUS) {
				result[i] = -1;
			}
		}

		return result;
	}

	private void dijikstra(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		this.distance[start - 1] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();
			int size = graph.get(now - 1).size();

			for (int i = 0; i < size; i++) {
				int next = graph.get(now - 1)
						.get(i);

				if (this.distance[next - 1] > this.distance[now - 1] + 1) {
					this.distance[next - 1] = this.distance[now - 1] + 1;
					q.add(next);
				}
			}
		}
	}

}
