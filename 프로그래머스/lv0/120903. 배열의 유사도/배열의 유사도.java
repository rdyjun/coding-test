import java.util.*;
class Solution {
    public int solution(String[] s1, String[] s2) {
        List<String> a = new ArrayList<String>(Arrays.asList(s2));
        List<String> b = new ArrayList<String>(Arrays.asList(s1));
        a.retainAll(b);
        return a.size();
    }
}