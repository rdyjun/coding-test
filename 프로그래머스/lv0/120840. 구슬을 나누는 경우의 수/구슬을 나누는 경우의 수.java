class Solution {
    public int lp (int bl, int sh) {
        if (bl == sh || sh == 0)
            return 1;
        else
            return lp(bl - 1, sh - 1) + lp(bl - 1, sh);
    }
    
    public int solution(int balls, int share) {
        return lp(balls, share);
    }
}