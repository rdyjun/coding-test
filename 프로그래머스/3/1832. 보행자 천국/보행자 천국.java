import java.util.Stack;

class Solution {
    final int MOD = 20170805;
    final int ROTATION = 0;
    final int STRAIGHT = 1;
    
    int m;
    int n;
    int[][][] visited; // x, y, 0은 오른쪽, 1은 아래
    int[][] cityMap;
    
    public int solution(int m, int n, int[][] cityMap) {
        this.m = m;
        this.n = n;
        this.visited = new int[m][n][2];
        this.cityMap = cityMap;
        
        int bottom = dfs(0, 1, 1) % this.MOD;
        int right = dfs(1, 0, 0) % this.MOD;
        
        return (right + bottom) % this.MOD;
    }
    
    private int dfs(int x, int y, int direction) {
        if (isArrive(x, y)) {                                       // 도착 지점 검사
            return 1;
        }
        
        if (x >= this.n || y >= this.m) {
            return 0;
        }
        
        int moveCount = moveToNext(x, y, direction);                // 직진             
        this.visited[y][x][direction] = -1;
        if (moveCount > 0) {
            this.visited[y][x][direction] = moveCount % this.MOD;
        }
        
        int rotationDirection = Math.abs(direction - 1);
        if (this.cityMap[y][x] == 2) {                              // 회전이 안되는 곳이면 중단
            return moveCount;
        }

        int rotationCount = moveToNext(x, y, rotationDirection);    // 회전
        this.visited[y][x][rotationDirection] = -1;
        if (rotationCount > 0) {
            this.visited[y][x][rotationDirection] = rotationCount % this.MOD;
        }
        
        return (moveCount + rotationCount) % this.MOD;
    }
    
    private boolean isArrive(int x, int y) {
        return x == this.n - 1 && y == this.m - 1;
    }
    
    /**
        특정 포지션 위치가 유효한지
        1. n, m을 초과하면 안된다.
        2. cityMap에서 1(통행 금지)이면 안된다.
        3. 이미 방문한 경우 직진, 회전 기록이 모두 -1이면 길이 없다는 의미로 안된다.
    */
    private boolean checkPositionAvailable(int x, int y) {
        if (x >= this.n || y >= this.m) {
            return false;
        }
        
        boolean isCarRoad = this.cityMap[y][x] != 1;
        boolean isBlockedRoad = this.visited[y][x][ROTATION] == -1 && this.visited[y][x][STRAIGHT] == -1;
        
        return isCarRoad && !isBlockedRoad;
    }
    
    private int moveToNext(int x, int y, int direction) {
        int nextX = x + Math.abs(direction - 1);
        int nextY = y + direction;
        
        if (!checkPositionAvailable(nextX, nextY)) { // 더 이상 길이 없는 경우
            return 0;
        }
        
        // 다음 포지션을 방문한 적이 없는 경우
        if (this.visited[nextY][nextX][ROTATION] == 0 || this.visited[nextY][nextX][STRAIGHT] == 0) {
            return dfs(nextX, nextY, direction);
        }
        // 다음 지점에서 이미 갔다온 기록을 반환
        return Math.max(this.visited[nextY][nextX][ROTATION], 0)
                + Math.max(this.visited[nextY][nextX][STRAIGHT], 0);
    }
}