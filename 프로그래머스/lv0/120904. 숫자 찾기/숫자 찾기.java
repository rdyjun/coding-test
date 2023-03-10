class Solution {
    public int solution(int num, int k) {
        int ans = String.valueOf(num).indexOf(String.valueOf(k));
        return ans += ans == -1 ? 0 : 1;
    }
}