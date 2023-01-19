class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int n = 0;
        for(int i = left; i <= right; i++){
            for(int k = 1; k <= i; k++){
                if(i % k == 0){
                    n += 1;
                }
            }
            if(n % 2 == 0){
                answer += i;
            } else {
                answer -= i;
            }
            n = 0;
        }
        return answer;
    }
}