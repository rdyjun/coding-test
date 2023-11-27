import java.util.*;

class Solution {
    private int answer = 0;
    public int solution(int m, int n, String[] board) {
        List<List<Character>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
            for (int k = m - 1; k >= 0; k--) {
                arr.get(i).add(board[k].charAt(i));
            }
        }
        boolean flags = true;
        while (flags) {
            boolean[][] square = getFourBlocks(arr, n, m);
            flags = removeSquare(arr, square, n, m);
        }
        return this.answer;
    }
    public boolean[][] getFourBlocks (List<List<Character>> arr, int n, int m) {
        boolean[][] square = new boolean[n][m];
        for (int i = 0; i < n - 1; i++) {
            List<Character> nowString = arr.get(i);
            List<Character> nextString = arr.get(i + 1);
            for (int k = 0; k < nowString.size() - 1; k++) {
                if (nextString.size() - 1 <= k)
                    break;
                char ch = arr.get(i).get(k);
                if (ch != arr.get(i).get(k + 1))
                    continue;
                if (ch != arr.get(i + 1).get(k))
                    continue;
                if (ch != arr.get(i + 1).get(k + 1))
                    continue;
                square[i][k] = true;
                square[i + 1][k + 1] = true;
                square[i + 1][k] = true;
                square[i][k + 1] = true;
            }
        }
        return square;
    }
    public boolean removeSquare (List<List<Character>> arr, boolean[][] square, int n, int m) {
        boolean flags = false;
        for (int i = 0; i < n; i++) {
            List<Character> str = arr.get(i);
            for (int k = str.size() - 1; k >= 0; k--) {
                if(square[i][k]) {
                    flags = true;
                    str.remove(k);
                    this.answer++;
                }
            }
        }
        return flags;
    }
}