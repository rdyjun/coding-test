import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        int len = number.length();
        for (int i = 0; i < len; i++) {
            int n = number.charAt(i);
            while(k > 0) {
                if (stk.isEmpty() || stk.peek() >= n)
                    break;
                k--;
                stk.pop();
            }
            stk.push(n);
        }
        while (!stk.isEmpty())
            stringBuilder.append(stk.pop() - '0');
        for (int i = 0; i < k; i++)
            stringBuilder.deleteCharAt(0);
        return stringBuilder
                .reverse()
                .toString();
    }
}