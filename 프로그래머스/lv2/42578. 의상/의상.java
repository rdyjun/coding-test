import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        int type = 0;
        
        for (String[] st : clothes)
            map.put(st[1], map.getOrDefault(st[1], 0) + 1);
        
        for (Integer i : map.values())
            answer *= i + 1;
        
        return answer - 1;
    }
}