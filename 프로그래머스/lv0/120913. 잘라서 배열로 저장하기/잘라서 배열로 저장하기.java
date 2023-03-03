class Solution {
    public String[] solution(String my_str, int n) {
        int l = my_str.length();
        String[] answer;
        int m;
        if(l % n == 0){
            answer = new String[l / n];
            m = answer.length;
        } else {
            answer = new String[l / n + 1];
            answer[answer.length - 1] = my_str.substring(l - (l % n), l);
            m = answer.length - 1;
        }
        
        for(int i = 0; i < m; i++){
            answer[i] = my_str.substring(i * n, i * n + n);
        }
        return answer;
    }
}