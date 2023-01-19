class Solution {
    public String solution(String s) {
        String answer = "";
        char[] n = s.toCharArray();
        char tmp;
        for(int i = 0; i < n.length - 1; i++){
            for(int k = 0 + i; k < n.length; k++){
                if(n[i] < n[k]){
                    tmp = n[i];
                    n[i] = n[k];
                    n[k] = tmp;
                }
            }
        }
        answer = String.valueOf(n);
        return answer;
    }
}