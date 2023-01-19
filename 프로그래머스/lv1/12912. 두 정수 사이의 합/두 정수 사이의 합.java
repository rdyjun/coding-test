class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b){
            answer = a;
        } else {
            int s, l;
            if (a > b){
                l = a;
                s = b;
            } else {
                l = b;
                s = a;
            }
            for(int i = s; i <= l; i++){
                answer += i;
            }
        }
        return answer;
    }
}