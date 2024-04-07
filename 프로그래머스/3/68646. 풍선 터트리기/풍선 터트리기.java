import java.util.*;

class Solution {
    
    public int solution(int[] a) {
        int n = a.length;
        int[][] left = new int[n][2]; // 0 = min 1 = max
        int[][] right = new int[n][2];
        left[0][0] = a[0];
        left[0][1] = a[0];
        right[n - 1][0] = a[n - 1];
        right[n - 1][1] = a[n - 1];
        
        for (int i = 1; i < n; i++) {
            if (a[i] < left[i - 1][0]) { // 이전 보다 더 작으면 업데이트
                left[i][0] = a[i];
            }
            
            if (a[i] >= left[i - 1][0]) {
                left[i][0] = left[i - 1][0];
            }
            
            if (a[i] > left[i - 1][1]) { // 이전보다 더 크면 업데이트
                left[i][1] = a[i];
            }
            
            if (a[i] <= left[i - 1][1]) {
                left[i][1] = left[i - 1][1];
            }
            
            int rightIndex = n - i - 1;
            
            if (a[rightIndex] < right[rightIndex + 1][0]) { // 이전보다 작으면 업데이트
                right[rightIndex][0] = a[rightIndex];
            }
            
            if (a[rightIndex] >= right[rightIndex + 1][0]) {
                right[rightIndex][0] = right[rightIndex + 1][0];
            }
            
            if (a[rightIndex] > right[rightIndex + 1][1]) { // 이전보다 크면 업데이트
                right[rightIndex][1] = a[rightIndex];
            }
            
            if (a[rightIndex] <= right[rightIndex + 1][1]) {
                right[rightIndex][1] = right[rightIndex + 1][1];
            }
        }
        
        boolean[] dp = new boolean[n];
        dp[0] = true;
        dp[n - 1] = true;
        
        for (int i = 1; i < n - 1; i++) {
            if (left[i - 1][0] > a[i] ||
               right[i + 1][0] > a[i]) {
                dp[i] = true;
                continue;
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                answer++;
            }
        }
        
        return answer;
    }
    
}