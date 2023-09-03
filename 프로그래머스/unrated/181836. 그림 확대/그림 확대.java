import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        String[] st = Arrays.stream(picture)
            .map(arr -> Arrays.stream(arr.split(""))
                    .map(v -> {
                        String s = "";
                        for (int i = 0; i < k; i++)
                            s += v;
                        return s;
                    })
                    .collect(Collectors.joining()))
            .toArray(String[]::new);
        
        for (int i = 0; i < picture.length * k; i++)
            answer[i] = st[i / k];
            
        return answer;
    }
}