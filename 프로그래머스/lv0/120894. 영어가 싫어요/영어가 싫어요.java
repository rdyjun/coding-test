import java.util.*;

class Solution {
    public long solution(String numbers) {
        long answer = 0; 
        if (numbers.length() >= 3) {
           ArrayList<String> arr = new ArrayList<>(Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"));
            
            String n;
            
            for (int i = 0; i < numbers.length() - 2; i++) {
                for (int k = i + 3; k <= numbers.length() && k <= i + 5; k++) {
                    n = numbers.substring(i, k);
                    if (arr.contains(n)) {
                        answer *= 10;
                        answer += arr.indexOf(n);
                        i = k - 1;
                    }
                }
            }
        }
        
        
        return answer;
    }
}