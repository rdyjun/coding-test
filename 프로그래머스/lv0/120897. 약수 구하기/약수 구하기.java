import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                answer.add(i);
        }
        
        int a = answer.size();
        int x = (int)Math.sqrt(n);
        int k = answer.size() - 1;
        
        if (x * x == n)
            answer.add(x);
        
        for (; k >= 0; k--)
             answer.add(n / answer.get(k));
        
        int[] ans = answer.stream().mapToInt(v -> v).toArray();
        return ans;
    }
}