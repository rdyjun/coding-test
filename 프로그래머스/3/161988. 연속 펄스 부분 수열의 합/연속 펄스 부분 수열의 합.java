import java.lang.Math;

class Solution {
    
    private int len;
    
    public long solution(int[] sequence) {
        this.len = sequence.length;
        
        int[] first = initializeArray(sequence, 1);
        int[] second = initializeArray(sequence, -1);
        
        long a = findMax(first);
        long b = findMax(second);
        
        if (a > b) {
            return a;
        }
        
        return b;
    }
    
    private int[] initializeArray(int[] array, int n) {
        int[] arr = new int[this.len];
        
        for (int i = 0; i < this.len; i++) {
            arr[i] = array[i] * n;
            
            n *= -1;
        }
        
        return arr;
    }
    
    private long findMax(int[] array) {
        long[] dp = new long[this.len];
        dp[0] = array[0];
        
        long max = dp[0];
        
        for (int i = 1; i < this.len; i++) {
            dp[i] = Math.max((long) dp[i - 1] + (long) array[i], (long) array[i]);
            
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        
        return max;
    }
    
}
