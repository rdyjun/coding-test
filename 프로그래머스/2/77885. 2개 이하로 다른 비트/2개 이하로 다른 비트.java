class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int numIndex = 0; numIndex < numbers.length; numIndex++) {
            String bnry = Long.toBinaryString(numbers[numIndex]);
            int bnrySize = bnry.length();
            for (int i = bnrySize - 1; i >= 0; i--) {
                if (bnry.charAt(i) == '0') {
                    String binary = bnry.substring(0, i) + "1";
                    if (i + 1 < bnry.length())
                        binary += bnry.substring(i + 1);
                    answer[numIndex] = Long.parseLong(binary, 2);
                    break;
                }
                if (i == 0) {
                    answer[numIndex] = Long.parseLong("10" + bnry.substring(1), 2);
                    break;
                }
                if (bnry.charAt(i - 1) == '0') {
                    String binary = bnry.substring(0, i - 1) + "10";
                    if (i + 1 < bnry.length())
                        binary += bnry.substring(i + 1);
                    answer[numIndex] = Long.parseLong(binary, 2);
                    break;
                }
            }
        }
        return answer;
    }
}