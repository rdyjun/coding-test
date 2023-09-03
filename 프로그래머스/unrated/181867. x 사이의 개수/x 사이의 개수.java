import java.util.*;

class Solution {
    public int[] solution(String myString) {
        myString = myString + "a";
        int[] answer = Arrays.stream(myString.split("x"))
            .mapToInt(v -> v.length())
            .toArray();
        answer[answer.length - 1]--;
        return answer;
    }
}