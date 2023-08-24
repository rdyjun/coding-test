import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length)
            return 1;
        if (arr1.length < arr2.length)
            return -1;
        int a = Arrays.stream(arr1)
            .sum();
        int b = Arrays.stream(arr2)
            .sum();
        
        if (a > b)
            return 1;
        if (a < b)
            return -1;
        
        return 0;
    }
}