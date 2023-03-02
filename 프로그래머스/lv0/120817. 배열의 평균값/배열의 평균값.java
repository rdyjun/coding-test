import java.util.Arrays;
class Solution {
    public double solution(int[] numbers) {
        return Arrays.stream(numbers).sum() / (float)numbers.length;
    }
}