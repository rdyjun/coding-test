class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int a;
        if(num % 2 == 0){
            a = (total / num) - ((num / 2) - 1);
        } else {
            a = (total / num) - (num / 2);
        }
        for(int i = 0; i < num; i++){
            answer[i] = a + i;
        }
        
        return answer;
    }
}