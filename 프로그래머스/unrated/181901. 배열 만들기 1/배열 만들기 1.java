import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int i = k; i <= n; i += k)
            arr.add(i);
        
        return arr.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}