class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int min = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            
            while (sum > n)
                sum -= min++;
            
            if (sum == n)
                answer++;
        }
        return answer;
    }
}