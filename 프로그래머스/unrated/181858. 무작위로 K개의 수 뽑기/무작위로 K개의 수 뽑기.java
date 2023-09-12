import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int k) {
        
        final int[] dis = Arrays.stream(arr)
            .distinct()
            .limit(k)
            .toArray();
        
        return IntStream.range(0, k)
            .map(v -> v >= dis.length ? -1 : dis[v])
            .toArray();
    }
}