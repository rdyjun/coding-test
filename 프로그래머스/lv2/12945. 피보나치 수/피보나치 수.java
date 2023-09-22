class Solution {
    
    public int solution(int n) {
        long a = 0;
        long b = 1;
        long tmp;
        for (int i = 1; i < n; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
            if (b > 1234567) {
                a %= 1234567;
                b %= 1234567;
            }
        }
            
        return (int)b;
    }
}