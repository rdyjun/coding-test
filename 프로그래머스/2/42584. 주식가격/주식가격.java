class Solution {
    private int getDuration (int start, int[] prices) {
        int n = prices[start];
        for (int idx = start + 1; idx < prices.length; idx++) {
            if (n > prices[idx])
                return idx - start;
        }
        return prices.length - start - 1;
    }
    public int[] solution(int[] prices) {
        int pricesSize = prices.length;
        int[] answer = new int[pricesSize];
        for (int idx = 0; idx < prices.length; idx ++) {
            answer[idx] = getDuration(idx, prices);
        }
        return answer;
    }
}