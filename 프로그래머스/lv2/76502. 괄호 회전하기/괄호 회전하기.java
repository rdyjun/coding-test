import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        char firstValue;
        int lastValue;
        
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            firstValue = s.charAt(i);
            if (firstValue == ']'
               || firstValue == '}'
               || firstValue == ')')
                continue;
            
            st.push(firstValue + 0);
            
            for (int k = i + 1; k < len + i; k++) {
                if (st.isEmpty()) {
                    st.push(s.charAt(k % len) + 0);
                    continue;
                }
                
                lastValue = st.pop();
                if (lastValue + 1 == s.charAt(k % len)
                   || lastValue + 2 == s.charAt(k % len))
                    continue;
                st.push(lastValue);
                st.push(s.charAt(k % len) + 0);
            }
            
            if (!st.isEmpty()) {
                st.clear();
                continue;
            }
            answer++;
        }
        return answer;
    }
}