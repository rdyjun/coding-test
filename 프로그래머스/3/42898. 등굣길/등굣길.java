class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] answer = new int[n][m];
        int[][] visited = new int[n][m];
        answer[0][0] = 1;
        setPuddles(visited, puddles);
        int x = 0;
        int y = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                checkRoute(answer, visited, row, col);
            }
        }
        return answer[n - 1][m - 1];
    }
    private void checkRoute (int[][] answer, int[][] visited, int row, int col) {
        if (visited[row][col] == 1)
            return;
        if (col != 0)
            answer[row][col] += answer[row][col - 1];
        if (row != 0)
            answer[row][col] += answer[row - 1][col];
        answer[row][col] %= 1000000007;
    }
    private void setPuddles (int[][] visited, int[][] puddles) {
        for (int[] i : puddles) {
            int x = i[0];
            int y = i[1];
            visited[y - 1][x - 1] = 1;
        }
    }
}