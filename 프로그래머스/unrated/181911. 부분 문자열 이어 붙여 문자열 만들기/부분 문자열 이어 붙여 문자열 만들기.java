import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        return IntStream.range(0, my_strings.length)
            .mapToObj(v -> my_strings[v].substring(parts[v][0], parts[v][1] + 1))
            .collect(Collectors.joining());
    }
}