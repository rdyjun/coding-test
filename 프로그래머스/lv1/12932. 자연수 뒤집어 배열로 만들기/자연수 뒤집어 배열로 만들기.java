class Solution {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        for(int i = 0; ; i++){
            answer[i] = (int)(n % 10);
            n /= 10;
            if(n < 1){
                break;
            }
        }
        return answer;
    }
}