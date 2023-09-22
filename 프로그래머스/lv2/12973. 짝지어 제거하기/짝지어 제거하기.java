import java.util.*;

class Solution {
    private String s;
    
    private int isPairOffString () {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < this.s.length(); i++) {
            Character intChar = this.s.charAt(i);
            
            if (stack.size() <= 0) {
                stack.push(intChar);
                continue;
            }
            
            Character lastStackValue = stack.pop();
            if (intChar != lastStackValue) {
                stack.push(lastStackValue);
                stack.push(intChar);
            }
        }
        if (stack.size() == 0)
            return 1;
        return 0;
    }
    
    public int solution(String s) {
        int answer = -1;
        this.s = s;

        return isPairOffString();
    }
}