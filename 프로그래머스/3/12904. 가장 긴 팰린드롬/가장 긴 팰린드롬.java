import java.lang.Math;

class Solution {
    
    private int len;
    
    private String s;
    
    public int solution(String s) {
        this.len = s.length();
        this.s = s;
        
        int halfLen = this.len / 2;
        int answer = getEvenPalindromeLength(halfLen - 1, halfLen);
        
        for (int i = 1; i <= halfLen; i++) {
            int left = halfLen - i;
            int right = halfLen + (i - 1);
            
            int result1 = getOddPalindromeLength(right);
            int result2 = getEvenPalindromeLength(right, right + 1);
            int result3 = getOddPalindromeLength(left);
            int result4 = getEvenPalindromeLength(left - 1, left);
            
            int max = Math.max(result1, result2);
            max = Math.max(max, result3);
            max = Math.max(max, result4);
            
            if (max > answer) {
                answer = max;
            }
        }

        return answer;
    }
    
    private int getOddPalindromeLength(int mid) {
        int number = 1;
        
        while (true) {
            if (mid + number >= this.len ||
                mid - number < 0 ||
                s.charAt(mid + number) != s.charAt(mid - number)) {
                break;
            }
            
            number++;
        }
        
        return number + number - 1;
    }
    
    private int getEvenPalindromeLength(int left, int right) {
        int number = 0;
        
        while (true) {
            if (right + number >= this.len ||
                left - number < 0 ||
                s.charAt(right + number) != s.charAt(left - number)) {
                break;
            }
            
            number++;
        }
        
        if (number == 0) {
            return 1;
        }
        
        return number + number;
    }
    
}