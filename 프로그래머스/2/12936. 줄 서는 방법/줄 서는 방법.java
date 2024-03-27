class Solution {
    
    private int n;
    
    public int[] solution(int n, long k) {
        this.n = n;

        long caseCount = getCaseCount();
        
        int number;
        int m = n;
        int[] answer = new int[n];
        int[] dp = new int[n];
        boolean[] visited = new boolean[n];
            
        for (int i = 0; i < n; i++) {
            if (k == 0L) {
                k += caseCount;
            }
            
            caseCount /= m;
            number = (int) (k / caseCount);
            
            if (k % caseCount > 0) {
                number++;
            }
            
            answer[i] = rotate(number, dp, visited);

            visited[answer[i] - 1] = true;
            addCase(answer[i], dp);
            
            m--;
                
            if (k > caseCount) {
                k %= caseCount;
            }
        }
        
        return answer;
    }
    
    private int rotate(int number, int[] dp, boolean[] visited) {
        int count = 0;
        int tmp;
        
        while (number <= this.n) {
            if (dp[number - 1] > count) {
                tmp = dp[number - 1];
                number += tmp - count;
                count = tmp;
                continue;
            }
            
            if (visited[number - 1]) {
                number++;
                continue;
            }
            
            break;
        }
        
        return number;
    }
    
    private void addCase(int number, int[] dp) {
        for (int i = number - 1; i < this.n; i++) {
            dp[i]++;
        }
    }
    
    private long getCaseCount() {
        long result = 1L;
        
        for (int i = 2; i <= this.n; i++) {
            result *= i;
        }
        
        return result;
    }
    
}
