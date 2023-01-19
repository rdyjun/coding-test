class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int p = 5;
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] wd = { "SUN","MON","TUE","WED","THU","FRI","SAT" };
        for(int i = 0; i < a - 1; i++){
            p += month[i];
        }
        p += b - 1;
        p %= 7;
        answer = wd[p];
        return answer;
    }
}