class Solution {
    public int[] solution(int n, int s) {
        if (n > s)
            return new int[]{-1};
        int[] answer = new int[n];
        int index = 0;
        
        for (int i = n; i >= 1; i--) {
            int div = s / i;
            answer[index] = div;
            index++;
            s -= div;
        }
        return answer;
    }
}