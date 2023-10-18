import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("[a, b, c]", "_");
        String[] answer = Arrays.stream(myStr.split("_"))
            .filter(v -> !v.equals(""))
            .toArray(String[]::new);
        if (answer.length == 0)
            return new String[]{"EMPTY"};
        return answer;
    }
}