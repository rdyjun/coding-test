import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        return Arrays.asList(my_string.split("")).stream().filter(v -> v.charAt(0) >= '0' && v.charAt(0) <= '9').mapToInt(v -> Integer.parseInt(v)).sorted().toArray();
    }
}