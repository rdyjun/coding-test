class Solution {
    public int solution(String[] spell, String[] dic) {
        loop:
        for(String dc : dic) {
            for (String sp : spell) {
                if (dc.indexOf(sp) < 0)
                    continue loop;
            }
            return 1;
        }
        return 2;
    }
}