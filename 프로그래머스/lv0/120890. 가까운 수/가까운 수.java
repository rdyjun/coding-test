import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int[] arr = array;
        Arrays.sort(arr);
        int answer = arr[0];
        
        int a = arr[0] - n;
        if (a < 0)
            a -= a * 2;
        
        for (int i = 1; i < arr.length; i++) {
            int b = arr[i] - n;
            if (b < 0)
                b -= b * 2;
            
            if (a > b){
                a = b;
                answer = arr[i];
            }
        }
        
        return answer;
    }
}