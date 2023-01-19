import java.util.*;

class Solution {
    public long solution(int n) {
        if(n<3){
            return n;
        }
        long a = 1;
        long b = 2;
        for(long i = 3; i < n + 1; i++){
            long c = a + b;
            if(c > 1234567){
                c -= 1234567;
            }
            a = b;
            b = c;
        }
        return b % 1234567;
    }
}