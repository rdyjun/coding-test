import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return Arrays.stream(myString.split(""))
            .map(v -> v.charAt(0) < 'l' ? "l" : v)
            .collect(Collectors.joining());
    }
}