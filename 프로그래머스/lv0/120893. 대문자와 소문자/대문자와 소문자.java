import java.util.*;

class Solution {
    public String solution(String my_string) {
        return String.join("", Arrays.asList(my_string.split("")).stream().map(v -> v.charAt(0) >= 'a' ? v.toUpperCase() : v.toLowerCase()).toArray(String[]::new));
    }
}