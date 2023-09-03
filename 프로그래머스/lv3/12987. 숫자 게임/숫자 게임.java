import java.util.*;

class Solution {
    private void reverseArray (int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            int tmp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tmp;
        }
    }
    
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length;
        
        Arrays.sort(A);
        reverseArray(A, len);
        Arrays.sort(B);
        reverseArray(B, len);
        
        boolean[] visited = new boolean[len];
        int n = 0;
        
        for (int i = 0; i < len; i++) {
            for (int k = n; k < len; k++) {
                if (visited[k])
                    continue;
                
                if (B[i] > A[k]) {
                    n = k + 1;
                    answer++;
                    visited[k] = true;
                    break;
                }
            }
        }
        return answer;
    }
}