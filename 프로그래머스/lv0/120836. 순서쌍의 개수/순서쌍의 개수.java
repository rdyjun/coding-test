import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = (int)Math.sqrt(n);
        for(int i = 1; i <= a; i++){
            if (n % i == 0)
                answer++;
        }
        answer *= 2;
        if(a * a == n){
            answer--;
        }
        return answer;
    }
}