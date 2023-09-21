import java.math.BigInteger;

class Solution {
    private int getOneCount (int binaryInt) {
        int answer = 0;
        while (binaryInt > 0) {
            if (binaryInt % 2 == 1)
                answer ++;
            binaryInt /= 2;
        }
        return answer;
    }
    
    public int solution(int n) {
        int oneCount = getOneCount(n);
        int compareNumber;
        while(true) {
            compareNumber = getOneCount(++n);
            
            if (compareNumber == oneCount)
                return n;
        }
        
    }
}