class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long a = Long.parseLong(p);
        int tlen = t.length();
        int plen = p.length();
        
        for(int i = 0; i < tlen - plen + 1; i++){
            if(a >= Long.parseLong(t.substring(i, i + plen)))
                answer++;
        }
        return answer;
    }
}