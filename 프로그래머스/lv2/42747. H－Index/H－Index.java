import java.util.*;

class Solution {
    public int solution(int[] citations) {        
        Arrays.sort(citations);
        int len = citations.length;
        if (citations[len - 1] == 0)
            return 0;
        
        int l = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] < l)
                return --l > i ? l : i;
            l++;
        }
        
        return len;
    }
}