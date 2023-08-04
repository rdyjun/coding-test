class Solution {
    public int[] solution(int n) {
        int len = 0;
        for (int i = 1; i <= n; i++)
            len += i;
        int[] answer = new int[len];
        
        int y = 0, x = 1, position = 0;
        int dy = n, rx = n, uy = 2;
        int dir = 1; // 1::왼쪽 아래  2::오른쪽  3::왼쪽 위
        for (int i = 1; i <= len; i++) {
            switch (dir) {
                case (1):
                    position += y; // 0 1 3 6 10
                    ++y; // 1 2 3 4 5 6
                    if (y == dy) {
                        dy--;
                        dir = 2;
                    }
                    break;
                case (2):
                    ++position;
                    ++x;
                    if (x == rx) {
                        dir = 3;
                        x = 1;
                        rx -= 3; // 4
                    }
                    break;
                case (3):
                    position -= y;
                    --y;
                    if (y == uy) {
                        dir = 1;
                        uy += 2;
                    }
            }
            answer[position] = i;
        }
        
        
        return answer;
    }
}