import java.util.*;

class Solution {
    private void createWantMap (Map<String, Integer> wantMap, String[] want, int[] number) {
        int arrayLen = number.length;
        for (int i = 0; i < arrayLen; i++) {
            wantMap.put(want[i], number[i]);
        }
    }
    
    private boolean checkArray (Map<String, Integer> map, Map<String, Integer> wantMap, String[] compareArray) {
        for (String st : compareArray) {
            if (map.getOrDefault(st, 0) < wantMap.get(st))
                return false;
        }
            
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> wantMap = new HashMap<>();
        int answer = 0;
        
        createWantMap(wantMap, want, number);
        
        for (int i = 0; i < discount.length && i < 10; i++)
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            
        if (checkArray(map, wantMap, want))
                answer++;
        
        for (int i = 0; i + 10 < discount.length; i++) {
            map.put(discount[i], map.get(discount[i]) - 1);
            map.put(discount[i + 10], map.getOrDefault(discount[i + 10], 0) + 1);
            
            if (checkArray(map, wantMap, want))
                answer++;
        }
        return answer;
    }
}