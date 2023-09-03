import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<Integer> arr =  IntStream.range(0, rank.length)
            .filter(v -> attendance[v])
            .boxed()
            .sorted((v1, v2) -> Integer.compare(rank[v1], rank[v2]))
            .limit(3)
            .collect(Collectors.toList());
        
        arr.set(0, arr.get(0) * 10000);
        arr.set(1, arr.get(1) * 100);
        
        return arr.stream()
            .mapToInt(v -> v)
            .sum();
    }
}