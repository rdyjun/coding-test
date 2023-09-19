import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public String solution(int q, int r, String code) {
        return IntStream.range(0, code.length())
            .filter(v -> v % q == r)
            .mapToObj(v -> code.charAt(v) + "")
            .collect(Collectors.joining());
    }
}