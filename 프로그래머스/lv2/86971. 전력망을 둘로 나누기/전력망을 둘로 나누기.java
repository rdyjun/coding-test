import java.util.*;

class Solution {
    public static int solution(int n, int[][] wires) {
        HashMap<Integer, HashSet<Integer>> arr = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> answerArr = new HashSet<>();
        int c;
        for (int i = 0; i < n - 1; i++) {
            arr.computeIfAbsent(wires[i][0], v -> new HashSet<>()).add(wires[i][1]);
            arr.computeIfAbsent(wires[i][1], v -> new HashSet<>()).add(wires[i][0]);
        }
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n];
            for (int k = 0; k < n; k++)
                visited[k] = true;

            visited[i - 1] = false;
            HashSet<Integer> subTree = arr.computeIfAbsent(i, v -> new HashSet<>());

            for (int k : subTree) {
                c = 0;
                q.add(k);
                while (!q.isEmpty()) {
                    int qNum = q.poll();
                    visited[qNum - 1] = false;
                    c++;
                    for (int j : arr.computeIfAbsent(qNum, v -> new HashSet<>())) {
                        if (visited[j - 1])
                            q.add(j);
                    }
                }
                int cases = c - (n - c);
                cases = cases < 0 ? -cases : cases;
                answerArr.add(cases);
            }
        }
        int min = -1;
        for (int i : answerArr) {
            if (min == -1) {
                min = i;
                continue;
            }
            if (min > i)
                min = i;
        }
        return min;
    }
}