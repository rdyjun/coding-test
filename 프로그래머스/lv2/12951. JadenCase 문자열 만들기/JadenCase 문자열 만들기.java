class Solution {
    public String solution(String s) {
        String ss[] = s.split("");
        String answer = "";
        ss[0] = ss[0].toUpperCase();

        for(int i = 1 ; i < ss.length; i++){
            if(ss[i - 1].charAt(0) == ' '){
                ss[i] = ss[i].toUpperCase();
            } else {
                ss[i] = ss[i].toLowerCase();
            }
        }
        for(int i = 0; i < ss.length; i++){
            answer += ss[i];
        }
        return answer;
    }
}