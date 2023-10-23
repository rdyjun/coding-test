import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.replaceAll("\\{", "");
        s = s.replaceAll("\\}", "");
        for (String ch : s.split(","))
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .map(Map.Entry::getKey)
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}