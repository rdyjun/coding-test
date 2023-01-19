class Solution {
    boolean solution(String s) {
        boolean answer;
        char[] cs = s.toCharArray();
        int p = 0;
        int y = 0;
        for(int i = 0; i < s.length(); i++){
            if(cs[i] == 'p' || cs[i] == 'P'){
                p += 1;
            } else if(cs[i] == 'y' || cs[i] == 'Y'){
                y += 1;
            }
        }
        answer = p == y;
        return answer;
    }
}