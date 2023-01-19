class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6){
            return false;
        }
        char[] a = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(a[i] - 48 < 0 || a[i] - 48 > 9){
                return false;
            }
        }
        return answer;
    }
}