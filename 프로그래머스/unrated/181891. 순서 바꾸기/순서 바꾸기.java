import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> arr = new ArrayList<>();
        for (int i = n; i < num_list.length; i++)
            arr.add(num_list[i]);
        for (int i = 0; i < n; i++)
            arr.add(num_list[i]);
            
        return arr.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}