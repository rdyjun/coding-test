import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger aa = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        return aa.add(bb)
            .toString();
    }
}