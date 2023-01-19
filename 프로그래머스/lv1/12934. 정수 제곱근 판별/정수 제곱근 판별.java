class Solution {
    public long solution(long n) {
        long answer = -1;
        double a = n / 2.0;
        for(long i = 1; i <= n; i++){
            if(a - i < 0){
                if(a * 2 == i){
                    answer = (i + 1) * (i + 1);
                }
                break;
            } else {
                a -= i;
            }
        }
        return answer;
    }
}