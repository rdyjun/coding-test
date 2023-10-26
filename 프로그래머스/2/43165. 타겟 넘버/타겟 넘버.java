class Solution {
    private int getAnswer (int target, int sum) {
        if(target == sum)
            return 1;
        return 0;
    }
    private int dfs (int sum, int len, char operator, int target, int[] numbers) {
        switch (operator) {
            case '+':
                sum += numbers[len];
                break;
            case '-':
                sum -= numbers[len];
                break;
        }
        if (len >= numbers.length - 1)
            return getAnswer(target, sum);
        return dfs(sum, len + 1, '-', target, numbers)
            + dfs(sum, len + 1, '+', target, numbers);
    }
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, '+', target, numbers)
            + dfs(0, 0, '-', target, numbers);
    }
}