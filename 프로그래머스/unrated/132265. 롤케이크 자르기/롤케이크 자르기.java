import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();
        HashMap<Integer, Integer> allCount = new HashMap<>();
        for (int i : topping) {
            int value = allCount.getOrDefault(i, 0);
            allCount.put(i, value + 1);
        }
        Set<Integer> arr = new HashSet<>();
        
        for (int i = 0; i < topping.length; i++) {
            int n = topping[i];
            arr.add(n);
            int c = allCount.get(n) - 1;
            if (c == 0)
                allCount.remove(n);
            else 
                allCount.put(n, c);
            
            if (arr.size() == allCount.size()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}