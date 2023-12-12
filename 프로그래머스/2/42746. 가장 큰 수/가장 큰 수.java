import java.util.Arrays;
import java.math.BigInteger;

class Solution {
    public String solution(int[] numbers) {
        numbers = Arrays.stream(numbers)
            .boxed()
            .sorted((v1, v2) -> compareNumber(v1, v2))
            .mapToInt(v -> v)
            .toArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : numbers)
            stringBuilder.append(num);
        BigInteger n = new BigInteger(stringBuilder.toString());
        return n.toString();
    }
    private int compareNumber (int firstNumber, int secondNumber) {
        String fNum = String.valueOf(firstNumber);
        String sNum = String.valueOf(secondNumber);
        if (fNum.equals(sNum))
            return 0;
        String f = fNum + sNum;
        String s = sNum + fNum;
        if (Integer.parseInt(f) > Integer.parseInt(s))
            return -1;
        return 1;
    }
    private void changeIndex (int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}