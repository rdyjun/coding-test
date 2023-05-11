import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int k, x = 0, y = 0;
        ArrayList<Integer> intArr = new ArrayList<>();
        int[] answer;
        
        for(int i : arr)
            intArr.add(i);
        
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                intArr.subList(query[i] + 1, intArr.size()).clear();
            } else {
                intArr.subList(0, query[i]).clear();
            }
        }
        
        answer = new int[intArr.size()];
        
        for (int i = 0; i < intArr.size(); i++)
            answer[i] = intArr.get(i);
        
        return answer;
    }
}