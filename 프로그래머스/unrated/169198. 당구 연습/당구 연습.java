import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int x;
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            answer[i] = -1;
            // 좌우
            if (startY != balls[i][1]) {
                answer[i] = (int)Math.pow(startX + balls[i][0], 2) + 
                    (int)Math.pow(startY - balls[i][1], 2);
                
                x = (int)Math.pow((m - startX) + (m - balls[i][0]), 2) + 
                    (int)Math.pow(startY - balls[i][1], 2);
                if (answer[i] > x)
                        answer[i] = x;
                
            } else {
                if (startX < balls[i][0]) {
                    x = (int)Math.pow(balls[i][0] + startX, 2);
                } else {
                    x = (int)Math.pow((m - startX) + (m - balls[i][0]), 2);
                }
                if (answer[i] == -1 || answer[i] > x)
                        answer[i] = x;
            }
            // 상하
            if (startX != balls[i][0]) {
                x = (int)Math.pow(startY + balls[i][1], 2) + 
                    (int)Math.pow(startX - balls[i][0], 2);
                if (answer[i] == -1 || answer[i] > x)
                    answer[i] = x;
                
                x = (int)Math.pow((n - startY) + (n - balls[i][1]), 2) + 
                    (int)Math.pow(startX - balls[i][0], 2);
                if (answer[i] > x)
                        answer[i] = x;
            } else {
                if (startY < balls[i][1]) {
                    x = (int)Math.pow(balls[i][1] + startY, 2);
                } else {
                    x = (int)Math.pow((n - startY) + (n - balls[i][1]), 2);
                }
                if (answer[i] == -1 || answer[i] > x)
                        answer[i] = x;
            }
        }
        return answer;
    }
}