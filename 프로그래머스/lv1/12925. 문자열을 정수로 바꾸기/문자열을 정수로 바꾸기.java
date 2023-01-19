class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] a = s.toCharArray();
        int num;
        
        for(int i = 0; i < a.length; i++){
            num = 1;
            for(int k = 1; k < a.length - i; k++){
                num *= 10;
            }
            if(a[i] == '-' || a[i] == '+'){
                continue;
            } else {
                answer += (a[i] - '0') * num;
            }
        }
        if(a[0] == '-'){
            answer *= -1;
        }
        return answer;
    }
}