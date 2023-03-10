import java.util.*;

class Solution {
    public String solution(String my_string) {
        return my_string.replaceAll("a", "").replaceAll("e", "").replace("i", "").replace("o", "").replace("u", "");
    }
}