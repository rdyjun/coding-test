import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Arrays.sort(delete_list);
        return Arrays.stream(arr)
            .filter(v -> Arrays.binarySearch(delete_list, v) < 0)
            .toArray();
    }
}