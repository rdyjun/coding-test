class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int dir = 2; // left : 1, right : 2, top : 3, down : 4
        int x = 0, y = 0;
        for (int i = 1; i <= n * n; i++) {
            answer[y][x] = i;
            switch(dir) {
                case 1:
                    if(x - 1 == -1 || answer[y][x - 1] > 0){
                        y--;
                        dir = 3;
                    } else
                        x--;
                    break;
                case 2:
                    if(x + 1 == n || answer[y][x + 1] > 0){
                        y++;
                        dir = 4;
                    } else
                        x++;
                    break;
                case 3:
                    if(y - 1 == -1 || answer[y - 1][x] > 0){
                        x++;
                        dir = 2;
                    } else
                        y--;
                    break;
                case 4:
                    if(y + 1 == n || answer[y + 1][x] > 0){
                        x--;
                        dir = 1;
                    } else
                        y++;
                    break;
            }
        }
        return answer;
    }
}