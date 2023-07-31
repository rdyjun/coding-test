import java.util.*;

class Solution {
    public int solution(int[] cards){
        int l = cards.length;
        boolean[] b = new boolean[l];
        
        // 초기화
        for (int k = 0; k < l; k++)
            b[k] = true;
        
        ArrayList<Integer> arr = new ArrayList<>();
        int n = cards[0] - 1;
        int min = 0;
        int s = 0;
        
        while (true) {
            if (!b[n]) {
                arr.add(s);
                if (n == min)
                    break;
                n = min;
                s = 0;
                continue;
            }
            b[n] = false;

            if (min == n)
                for (int j = min + 1; j < l; j++)
                    if (b[j]) {
                        min = j;
                        break;
                    }

            n = cards[n] - 1;
            s++;
        }
        
        Collections.sort(arr);
        if (arr.size() < 2)
            return 0;
        return arr.get(arr.size() - 1) * arr.get(arr.size() - 2);
    }
}