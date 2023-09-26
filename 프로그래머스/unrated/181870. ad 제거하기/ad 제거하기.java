import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr)
            .filter(v -> !v.contains("ad"))
            .toArray(String[]::new);
    }
}