class Solution {
    
    public int gcd(int a, int b) {
        int m = a % b;
        if (m == 0)
            return b;
        return gcd(b, a % b);
    }
    
    public int solution(int a, int b) {
        int bb = b / gcd(a, b);
        while(true) {
            if (bb % 2 == 0)
                bb /= 2;
            else if (bb % 5 == 0)
                bb /= 5;
            else
                break;
        }
        
        return (a % b == 0 || bb == 1) ? 1 : 2;
    }
}