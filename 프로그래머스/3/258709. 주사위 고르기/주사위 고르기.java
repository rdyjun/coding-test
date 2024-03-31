import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Solution {

	private int diceCount;

	private List<List<Integer>> arr;

	private List<int[]> dicesList;

	private int[][] dice;

	public int[] solution(int[][] dice) {
		this.diceCount = dice.length;
		this.dice = dice;
		this.arr = new ArrayList<>();
		this.dicesList = new ArrayList<>();

		List<Integer> firstCase = new ArrayList<>();
		firstCase.add(0);

		dfs(-1, 0, new int[diceCount / 2], firstCase);

		int range = arr.size();
		int max = 0;
		int[] answer = null;

		for (int i = 0; i < range / 2; i++) {
			int[] result = getWinCount(arr.get(i), arr.get(range - i - 1));

			if (result[0] > result[1] && result[0] > max) {
				max = result[0];
				answer = dicesList.get(i);
			}

			if (result[1] > result[0] && result[1] > max) {
				max = result[1];
				answer = dicesList.get(range - i - 1);
			}
		}

		return answer;
	}

	private void dfs(int index, int number, int[] dices, List<Integer> cases) {
		if (index == this.diceCount / 2 - 1) {
			arr.add(cases);
			dicesList.add(dices);
			return;
		}

		int limit = this.diceCount - (this.diceCount / 2 - index - 2);

		for (int i = number + 1; i <= limit; i++) {
			dices[index + 1] = i;
			List<Integer> tmpCases = new ArrayList<>();

			for (int k : this.dice[i - 1]) {
				for (int j : cases) {
					tmpCases.add(k + j);
				}
			}

			dfs(index + 1, i, dices.clone(), tmpCases);
		}
	}

	private int[] getWinCount(List<Integer> a, List<Integer> b) {
		Collections.sort(a);
		Collections.sort(b);
		int[] win = new int[2];

		for (int i : a) {
			win[0] += binarySearch(i, b);
		}

		for (int i : b) {
			win[1] += binarySearch(i, a);
		}

		System.out.println(win[0] + " :: " + win[1]);

		return win;
	}

	private int binarySearch(int num, List<Integer> arr) {
		int left = 0;
		int right = arr.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (num > arr.get(mid)) {
				left = mid + 1;
				continue;
			}

			if (num <= arr.get(mid)) {
				right = mid - 1;
			}
		}

		return left;
	}

}