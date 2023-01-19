class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;
        int[] n2 = new int[1];
        int nlen;
        for(int i = 1; i < n; i++){
            if(num * 3 - 1 > n){
                n2 = new int[i];
                break;
            }
            num *= 3;
        }
        num = 1;
        for(int i = 0; i < n2.length; i++){
            n2[i] = n % 3;
            n /= 3;
        }
        for(int i = 0; i < n2.length; i++){
            for(int k = 0; k < i; k++){
                num *= 3;
            }
            answer += n2[n2.length - 1 - i] * num;
            num = 1;
        }
        
        return answer;
    }
}