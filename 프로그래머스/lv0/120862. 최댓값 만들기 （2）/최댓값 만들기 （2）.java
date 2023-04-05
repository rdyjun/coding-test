import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int x = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int y = numbers[0] * numbers[1];
        return x > y ? x : y;
    }
}