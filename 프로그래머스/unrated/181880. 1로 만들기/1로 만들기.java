class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int i : num_list) {
            for (int k = 1; k <= i; k *= 2) {
                answer++;
            }
            answer--;
        }
        return answer;
    }
}