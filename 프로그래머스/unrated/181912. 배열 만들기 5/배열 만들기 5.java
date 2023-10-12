import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
            .map(v -> v.substring(s, l + s))
            .mapToInt(Integer::parseInt)
            .filter(v -> v > k)
            .toArray();
    }
}