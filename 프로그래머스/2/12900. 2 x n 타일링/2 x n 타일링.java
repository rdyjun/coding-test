class Solution {
    public int solution(int n) {
        int prev = 1;
        int next = 1;
        for (int i = 1; i < n; i++) {
            int tmp = (prev + next) % 1000000007;
            prev = next;
            next = tmp;
        }
        return next;
    }
}