import java.util.*;

public class Solution {
    private int moveCount = 0;
    
    private int getNextValue (int n) {
        if (n % 2 == 0)
            return n / 2;
        this.moveCount++;
        return n - 1;
    }
    
    public int solution(int n) {
        while(n > 0)
            n = getNextValue(n);

        return this.moveCount;
    }
}