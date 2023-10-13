import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (String s : strArr)
            m.put(s.length(), m.getOrDefault(s.length(), 0) + 1);
        
        int max = -1;
        
        for (int i : m.keySet())
            if (max == -1 || m.get(i) > m.get(max))
                max = i;
        
        return m.get(max);
    }
}