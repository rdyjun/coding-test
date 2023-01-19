class Solution {
    public String solution(int n) {
        String answer = "";
        char[] a = {'수','박'};
        
        for(int i = 1; i <= n; i++){
            if(i%2 == 1){answer += a[0];}
            if(i%2 == 0){answer += a[1];}
        }
        return answer;
    }
}