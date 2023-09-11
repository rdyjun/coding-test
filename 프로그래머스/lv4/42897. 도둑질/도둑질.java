import java.util.*;

class Solution {
    private int getMax (int[] arr, int len, int t) {
        int i = 4;
        if (t == 0)
            arr[3] += arr[1];
        
        if (t == 1) {
            arr[2] += arr[0];
            i = 3;
            len -= 1;
        }
        
        
        for (; i < len; i++) {
            if (arr[i - 2] == arr[i - 3]) {
                arr[i] += arr[i - 2];
                continue;
            }
            if (arr[i - 2] > arr[i - 3]) {
                arr[i] += arr[i - 2];
                continue;
            }
            arr[i] += arr[i - 3];
        }
        if (t == 1)
            return arr[len - 1] > arr[len - 2] ? arr[len - 1] : arr[len - 2];
        
        return arr[len - 1];
    }
    
    public int solution(int[] money) {
        int len = money.length;
        
        if (len == 3)
            return Arrays.stream(money)
            .boxed()
            .max(Integer::compareTo)
            .orElse(-1);
        
        int a = getMax(money.clone(), len, 0);
        int b = getMax(money.clone(), len, 1);
        
        if (a > b)
            return a;
        
        return b;
    }
}

