class Solution {
    public int solution(int[][] dots) {
        int x = 0, y = 0;
        for(int i = 1 ; i < 4; i++) {
            if(dots[i][0] == dots[0][0]){
                y = dots[0][1] - dots[i][1];
                if (y < 0)
                    y *= -1;
            }
            if(dots[i][1] == dots[0][1]){
                x = dots[0][0] - dots[i][0];
                if (x < 0)
                    x *= -1;
            }
        }
        return x * y;
    }
}