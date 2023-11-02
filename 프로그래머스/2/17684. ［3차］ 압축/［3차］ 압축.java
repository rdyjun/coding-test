import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        int maxIndex = 27;
        int c = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(String.valueOf(ch), c);
            c++;
        }
        int k;
        String compareString = "";
        for (int i = 0; i < msg.length(); i++) {
            for (k = i + 2; k <= msg.length(); k++) {
                compareString = msg.substring(i, k);
                int index = map.getOrDefault(compareString, -1);
                if (index == -1) {
                    map.put(compareString, maxIndex);
                    break;
                }
            }
            arr.add(map.get(msg.substring(i, k - 1)));
            i = k - 2;
            maxIndex++;
        }
        return arr.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}