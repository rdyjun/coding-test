import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] names) {
        return IntStream.range(0, names.length)
            .filter(v -> v % 5 == 0)
            .mapToObj(v -> names[v])
            .toArray(String[]::new);
    }
}