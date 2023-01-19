class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int n = 0;
        for(int i = 0; i < win_nums.length; i++){
            for(int k = 0; k < win_nums.length; k++){
                if(lottos[k] == win_nums[i]){
                    n += 1;
                }
            }
        }
        if(n == 0){
            answer[1] = 6;
        } else {
            answer[1] = 7 - n;
        }
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                n += 1;
            }
        }
        if(n == 0){
            answer[0] = 6;
        } else {
            answer[0] = 7 - n;
        }
        return answer;
    }
}