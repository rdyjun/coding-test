import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Comparator;

class Solution {
    
    private static int MAX_POINT = 100000;
    
    public int solution(int[][] scores) {
        int employee = scores.length;
        
        int[] sum = new int[employee];
        int[] dp = new int[MAX_POINT + 1];
        
        int a, b;
        
        for (int i = 0; i < employee; i++) {
            a = scores[i][0];
            b = scores[i][1];
            
            if (a > 0 && dp[a - 1] < b) {
                dp[a - 1] = b;
            }
            
            sum[i] = a + b;
        }
        
        calcDp(dp);
        
        int[] arr = IntStream.range(0, employee)
            .filter(v -> scores[v][1] >= dp[scores[v][0]])
            .boxed()
            .sorted(Comparator.comparingInt(v -> sum[v] * -1))
            .mapToInt(v -> v)
            .toArray();
        
        int max = Integer.MAX_VALUE;
        int prevRankCount = 1;
        int rank = 0;
        
        for (int i : arr) {
            if (sum[i] == max) {
                prevRankCount++;
            }
            
            if (sum[i] < max) {
                max = sum[i];
                rank += prevRankCount;
                prevRankCount = 1;
            }
            
            if (i == 0) {
                return rank;
            }
        }
        
        return -1;
    }
    
    private void calcDp(int[] dp) {
        int max = Integer.MIN_VALUE;
        
        for (int i = MAX_POINT; i >= 0; i--) {
            if (dp[i] > max) {
                max = dp[i];
                continue;
            }
            
            dp[i] = max;
        }
    }
    
}

/*
[16, 30, 35, 44, 53, 62, 71]
6554321

*/
