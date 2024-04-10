import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {

	private static final Integer FRIEND_COUNT = 8;

	private static final Integer FIRST_TARGET_INDEX = 0;

	private static final Integer SECOND_TARGET_INDEX = 2;

	private static final Integer TYPE_INDEX = 3;

	private static final Integer VALUE_INDEX = 4;

	private static final Character[] CHARACTER_LIST = new Character[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

	private Integer answer = 0;

	private Integer[][] distanceListGreater;

	private Integer[][] distanceListLess;

	private Integer[][] distanceListEquals;

	private Map<Character, Integer> character;

	public int solution(int n, String[] data) {
		initializeCharacterMap();

		if (!initializeDistanceList(data)) {
			return 0;
		}

		for (int friendIndex = 0; friendIndex < FRIEND_COUNT; friendIndex++) {
			boolean[][] visited = new boolean[FRIEND_COUNT][FRIEND_COUNT];
			checkVisited(friendIndex, 0, visited);

			int[] characterOrder = new int[FRIEND_COUNT];
			characterOrder[0] = friendIndex;

			dfs(0, characterOrder, visited);
		}

		return this.answer;
	}

	private void dfs(int index, int[] characterOrder, boolean[][] visited) {
		if (index + 1 == FRIEND_COUNT) {
			this.answer++;

			return;
		}

		for (int i = 0; i < FRIEND_COUNT; i++) {
			if (visited[index + 1][i]) {
				continue;
			}

			boolean[][] tmp = visitedDeepCopy(visited);
			checkVisited(i, index + 1, tmp);

			characterOrder[index + 1] = i;
			dfs(index + 1, characterOrder.clone(), tmp);
		}
	}

	private boolean[][] visitedDeepCopy(boolean[][] visited) {
		boolean[][] tmpVisited = new boolean[FRIEND_COUNT][FRIEND_COUNT];

		for (int i = 0; i < FRIEND_COUNT; i++) {
			tmpVisited[i] = visited[i].clone();
		}

		return tmpVisited;
	}

	/** visited에 이후 자리의 들어오지 못하는 친구들 체크 */
	private void checkVisited(int friendIndex, int index, boolean[][] visited) {
		for (int checkFriend = 0; checkFriend < FRIEND_COUNT; checkFriend++) {
			visited[checkFriend][friendIndex] = true; // 모든 위치에 friendIndex 방문 처리

			Integer greater = this.distanceListGreater[friendIndex][checkFriend];
			Integer less = this.distanceListLess[friendIndex][checkFriend];
			Integer equal = this.distanceListEquals[friendIndex][checkFriend];

			if (equal != null) {
				for (int k = index + 1; k < FRIEND_COUNT; k++) {
					if (k != index + equal + 1) {
						visited[k][checkFriend] = true;
					}
				}
			}

			if (greater != null) {
				for (int k = index + 1; k <= index + greater + 1 && k < FRIEND_COUNT; k++) {
					visited[k][checkFriend] = true;
				}
			}

			if (less != null) {
				for (int k = index + less + 1; k < FRIEND_COUNT; k++) {
					visited[k][checkFriend] = true;
				}
			}
		}
	}

	private void initializeCharacterMap() {
		this.character = new HashMap<>();

		for (int i = 0; i < FRIEND_COUNT; i++) {
			this.character.put(CHARACTER_LIST[i], i);
		}
	}

	private boolean initializeDistanceList(String[] data) {
		this.distanceListGreater = new Integer[FRIEND_COUNT][FRIEND_COUNT];
		this.distanceListLess = new Integer[FRIEND_COUNT][FRIEND_COUNT];
		this.distanceListEquals = new Integer[FRIEND_COUNT][FRIEND_COUNT];

		for (String d : data) {
			int target1 = character.get(d.charAt(FIRST_TARGET_INDEX));
			int target2 = character.get(d.charAt(SECOND_TARGET_INDEX));
			int distance = d.charAt(VALUE_INDEX) - '0';
			char type = d.charAt(TYPE_INDEX);

			if (type == '=') {
				if (this.distanceListEquals[target1][target2] != null &&
						this.distanceListEquals[target1][target2] != distance) {
					return false;
				}

				this.distanceListEquals[target1][target2] = distance;
				this.distanceListEquals[target2][target1] = distance;
			}

			if (type == '>') {
				if (this.distanceListGreater[target1][target2] == null ||
					this.distanceListGreater[target1][target2] < distance) {
					this.distanceListGreater[target1][target2] = distance;
					this.distanceListGreater[target2][target1] = distance;
				}
			}

			if (type == '<') {
				if (this.distanceListLess[target1][target2] == null ||
					this.distanceListLess[target1][target2] > distance) {
					this.distanceListLess[target1][target2] = distance;
					this.distanceListLess[target2][target1] = distance;
				}
			}
		}

		return true;
	}

}
