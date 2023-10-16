import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int m, int c) {
        return IntStream.range(0, my_string.length())
            .filter(v -> v % m == c - 1)
            .mapToObj(v -> String.valueOf(my_string.charAt(v)))
            .collect(Collectors.joining());
    }
}