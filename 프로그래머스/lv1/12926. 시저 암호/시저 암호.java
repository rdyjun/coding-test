class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] a = s.toCharArray();
        for(int i = 0; i < a.length; i++){
            if(a[i] == ' '){
                continue;
            } else if((a[i] + n > 122 && a[i] >= 97) || (a[i] + n > 90 && a[i] < 97)){
                a[i] = (char)(a[i] + n - 26);
            } else {
                a[i] = (char)(a[i] + n);
            }
        }
        answer = String.valueOf(a);
        return answer;
    }
}