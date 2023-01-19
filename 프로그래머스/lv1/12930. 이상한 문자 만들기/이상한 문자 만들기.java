class Solution {
    public String solution(String s) {
        char[] a = s.toCharArray();
        int num = -1;
        for(int i = 0; i < a.length; i++){
            if(a[i] == ' '){
                num = i;
            } else {
                if((i - (num + 1)) % 2 == 0 && a[i] >= 95){
                    a[i] = (char)(a[i] - 32);
                } else if((i - (num + 1)) % 2 != 0 && a[i] < 95){
                    a[i] = (char)(a[i] + 32);
                }
            }
        }
        String answer = String.valueOf(a);
        return answer;
    }
}