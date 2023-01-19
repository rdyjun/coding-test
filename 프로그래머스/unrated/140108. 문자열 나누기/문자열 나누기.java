class Solution {
    public int solution(String s) {
        int answer = 0;
        char x;
        int a;  //x 개수
        int b;  //x가 아닌 개수
        
        while(s.length() > 1){
            x = s.charAt(0);
            a = 1;
            b = 0;
            
            for(int k = 1; k < s.length(); k++){
                if(x == s.charAt(k))
                    a++;
                else
                    b++;
                
                if(a == b){
                    s = s.replaceFirst(s.substring(0, k + 1), "");
                    break;
                }
                if (k == s.length() - 1)
                    return ++answer;
            }
            answer++;
        }
        if(s.length() == 1){
                answer++;
        }
        return answer;
    }
}