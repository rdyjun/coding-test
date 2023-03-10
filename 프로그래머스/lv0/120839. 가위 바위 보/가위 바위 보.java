class Solution {
    public String solution(String rsp) {
        String answer = "";
        for(int i = 0; i < rsp.length(); i++){
            char a = rsp.charAt(i);
            answer += a == '2' ? "0" : a == '0' ? "5" : "2";
        }
            
        return answer;
    }
}