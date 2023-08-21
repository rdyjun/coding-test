import java.util.*;

class Solution {
    public int solution(String[] words) {
        int len = words.length;
        int[] arr = new int[len];
        
        arr = Arrays.stream(arr)
            .map(v -> v == 0 ? 1 : v)
            .toArray();
        
        words = Arrays.stream(words)
            .sorted((v1, v2) -> Integer.compare(v1.length(), v2.length()))
            .sorted((v1, v2) -> v1.compareTo(v2))
            .toArray(String[]::new);
        
        boolean flags;
        boolean bigFlags;
        
        for (int i = 0; i < len; i++) {
            
            for (int k = arr[i]; k <= words[i].length(); k++) {
                bigFlags = true;
                for(int j = i + 1; j < len; j++) {
                    flags = true;
                    if (j == i || arr[j] >= words[j].length() || words[j].length() < k)
                        continue;
                    
                    if (words[j].substring(0, k).compareTo(words[i].substring(0, k)) == 0) {
                        arr[i] = k + 1;
                        arr[j] = k + 1;
                        flags = false;
                        bigFlags = false;
                    }
                    if (flags)
                        break;
                }
                if (bigFlags)
                    break;
            }
        }
        for (int i = 0; i < len; i++)
            if (words[i].length() <= arr[i])
                arr[i] = words[i].length();
            
        return Arrays.stream(arr)
            .sum();
    }
}