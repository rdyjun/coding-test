class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] ans = my_string.split("");
        String tmp = ans[num1];
        ans[num1] = ans[num2];
        ans[num2] = tmp;
        String answer = String.join("", ans);
        return answer;
    }
}