class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] m = String.valueOf(n).toCharArray();
        char tmp;
        long num;
        
        for(int i = 0; i < m.length - 1; i++){
            for(int k = i + 1; k < m.length; k++){
                if(m[i] < m[k]){
                    tmp = m[i];
                    m[i] = m[k];
                    m[k] = tmp;
                }
            }
        }
        //Array를 넣을 경우 m.sort();
        for(int i = 0; i < m.length; i++){
            num = 1;
            for(int k = 0; k < m.length - 1 - i; k++){
                num *= 10;
            }
            answer += (m[i] - '0') * num;
        }
        
        return answer;
    }
}