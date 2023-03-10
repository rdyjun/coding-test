import java.util.*;
class Solution {
    public int solution(String my_string) {
        return Arrays.asList(my_string.split("")).stream()
            .filter(i -> i.charAt(0) >= '0' && i.charAt(0) <= '9')
            .mapToInt(i -> Integer.parseInt(i)).sum();
    }
}