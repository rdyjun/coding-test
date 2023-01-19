import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        char[] m = String.valueOf(n).toCharArray();
        
        for(int i = 0; i < m.length; i++){
            answer += m[i] - '0';
        }
        return answer;
    }
}