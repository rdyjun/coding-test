import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int max = -1;
        ArrayList<Integer> arr = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            int n = progresses[i];
            arr.add((int)Math.ceil((float)(100 - n) / speeds[i]));
        }
        
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
            if (max == -1 || max < arr.get(i)) {
                max = arr.get(i);
                map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
                continue;
            }
            map.put(max, map.get(max) + 1);
        }
        arr = new ArrayList<>();
        for (Integer key : map.keySet())
            arr.add(map.get(key));
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            answer[i] = arr.get(i);
        return answer;
    }
}