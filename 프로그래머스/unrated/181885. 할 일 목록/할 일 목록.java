import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, todo_list.length)
            .filter(v -> !finished[v])
            .mapToObj(v -> todo_list[v])
            .toArray(String[]::new);
    }
}