import java.lang.Math;

class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;
        for (int i = (int)Math.sqrt(size); i >= 3; i--)
            if (size % i == 0 && (size / i - 2) * (i - 2) == yellow)
                return new int[]{size / i, i};
        
        return new int[]{1, 1};
    }
}