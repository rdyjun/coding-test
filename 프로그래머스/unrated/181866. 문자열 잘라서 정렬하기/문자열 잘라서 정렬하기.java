import java.util.*;

class Solution {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x"))
            .filter(v -> !v.equals(""))
            .sorted(Comparator.naturalOrder())
            .toArray(String[]::new);
    }
}