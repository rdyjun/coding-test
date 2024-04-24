class Solution {
    
    public int[] solution(long[] numbers) {
        int numberCount = numbers.length;
        
        int[] answer = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            answer[i] = isAvailable(numbers[i]);
        }
        
        return answer;
    }
    
    private int isAvailable(long number) {
        String binaryNumber = Long.toBinaryString(number);
        binaryNumber = fillZero(binaryNumber);
        int result = dfs(binaryNumber);
        
        if (result == -1) {
            return 0;
        }
        
        return 1;
    }
    
    private int dfs(String binaryNumber) {
        int binaryNumberLength = binaryNumber.length();
        
        if (binaryNumberLength == 1) {
            return Integer.parseInt(binaryNumber);
        }
        
        int mid = binaryNumber.charAt(binaryNumberLength / 2) - '0';
        
        int left = dfs(binaryNumber.substring(0, binaryNumberLength / 2));
        int right = dfs(binaryNumber.substring(binaryNumberLength / 2 + 1));
        
        if (left == -1 ||
           right == -1 ||
           (left + right > 0 && mid == 0)) {
            return -1;
        }
        
        return mid;
    }
    
    private String fillZero(String binaryNumber) {
        int sum = 1;
        int binaryNumberLength = binaryNumber.length();
        
        while (binaryNumberLength > sum) {
            sum *= 2;
            sum++;
        }
        
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < sum - binaryNumberLength; i++) {
            stb.append("0");
        }
        
        stb.append(binaryNumber);
        
        return stb.toString();
    }
    
}
