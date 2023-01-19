class Solution {
    boolean solution(String s) {
        int a = 0;
        for (char i : s.toCharArray()){
            a += i == '(' ? 1 : -1;
            if (a < 0)
                return false;
        }
        return a == 0;
    }
}