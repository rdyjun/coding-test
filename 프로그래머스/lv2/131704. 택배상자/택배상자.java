import java.util.*;

class Solution {
    public int solution(int[] order) {
        int n = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            if (order[n] == i) {
                n++;
                continue;
            }
            if (!st.isEmpty() && st.peek() == order[n]) {
                st.pop();
                n++;
                i--;
                continue;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            if (order[n] == st.pop()) {
                n++;
                continue;
            }
            break;
        }
        return n;
    }
}