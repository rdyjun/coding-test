import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        int cnt = 2;
        for(int i = 2; i <= number; i++) {
            if ((int)Math.sqrt(i) * (int)Math.sqrt(i) == i)
                cnt--;
            for ( int k = 2; k <= Math.sqrt(i); k++ ) {
                if (i % k == 0){
                    cnt += 2;
                    if(cnt > limit){
                        cnt = power;
                        break;
                    }
                }
            }
            answer += cnt;
            cnt = 2;
        }
        return answer;
    }
}