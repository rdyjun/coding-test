import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String st = "0";
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c <= '9' && c >= '0')
                st += c;
            else {
                answer += Integer.parseInt(st);
                st = "0";
            }
        }
        return answer += Integer.parseInt(st);
    }
}