import java.util.*;

class Solution {
    private boolean isPrimeNumber (long num) {
        long sqrtValue = (long)Math.sqrt(num);
        for (long i = 2; i < sqrtValue; i++) {
            if (num % i == 0)
                return false;
        }
        if (sqrtValue * sqrtValue == num)
            return false;
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k);
        String[] splitNumber = number.split("0");
        for (String str : splitNumber) {
            if (str.equals("1") || str.equals(""))
                continue;
            if (isPrimeNumber(Long.parseLong(str)))
                answer++;
        }
        return answer;
    }
}