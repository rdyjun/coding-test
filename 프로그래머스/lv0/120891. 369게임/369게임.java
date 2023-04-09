class Solution {
    public int solution(int order) {
        int answer = 0;
        for (int i = 0; order > 0; i++) {
            if ((order % 10) != 0 && (order % 10) % 3 == 0)
                answer++;
            order /= 10;
        }
        return answer;
    }
}