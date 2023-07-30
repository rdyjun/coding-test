import java.util.*;

class Solution {public int solution(int []A, int []B) {
        int l = A.length;
        int sum = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < l; i++)
            sum += A[i] * B[l - i - 1];
            
        

        return sum;
    }
}