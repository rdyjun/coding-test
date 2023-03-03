class Solution {
    public String solution(String my_string) {
        char[] c = my_string.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(c[i] >= 65 && c[i] <= 90){
                c[i] += 32;
            }
        }
        for(int i = 0; i < c.length - 1; i++){
            for(int j = 1 + i; j < c.length; j++){
                if(c[i] > c[j]){
                    char a = c[i];
                    c[i] = c[j];
                    c[j] = a;
                }
            }
        }
        String answer = String.valueOf(c);
        return answer;
    }
}