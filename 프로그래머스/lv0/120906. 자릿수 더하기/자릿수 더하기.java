import java.util.*;

class Solution {
    public int solution(int n) {
        return Arrays.asList(String.valueOf(n).split("")).stream().mapToInt(m -> Integer.parseInt(m)).sum();
    }
}