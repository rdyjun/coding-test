class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer++;
            while (answer % 3 == 0 || String.valueOf(answer).indexOf("3") >= 0)
                answer++;
        }
        
        return answer;
    }
}