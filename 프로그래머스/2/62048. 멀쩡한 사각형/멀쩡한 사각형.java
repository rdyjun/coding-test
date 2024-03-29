class Solution {
    
    public long solution(int w, int h) {
        long area = (long) w * h;
        
        long gcd = (long) gcd(w, h);
        long v = (w + h) / gcd - 1;
        
        return area - v * gcd;
    }
    
    private int gcd(int w, int h) {
        if (h == 0) {
            return w;
        }
        
        return gcd(h, w % h);
    }
    
}