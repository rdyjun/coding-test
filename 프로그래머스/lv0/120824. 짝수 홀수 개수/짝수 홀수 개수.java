class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0){
                answer[0]++;
            }
        }
        answer[1] = num_list.length - answer[0];
        return answer;
    }
}