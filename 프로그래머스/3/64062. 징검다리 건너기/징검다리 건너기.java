import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] stones, int k) {  
        int answer = -1;
        
        int left = 0;
        int right = 200000000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int sum = 0;
            
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > mid) {
                    sum = 0;
                    continue;
                }
                
                sum++;
                
                if (sum >= k) {
                    break;
                }
            }
            
            if (sum >= k) {
                answer = mid;
                right = mid - 1;
                continue;
            }
            
            left = mid + 1;
        }
        return answer;
    }
}