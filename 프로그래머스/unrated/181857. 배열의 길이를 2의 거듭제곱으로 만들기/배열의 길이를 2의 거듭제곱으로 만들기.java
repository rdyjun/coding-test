class Solution {
    public int[] solution(int[] arr) {
        int n = 1;
        
        while (n < arr.length) 
            n *= 2;
        
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (arr.length <= i){
                answer[i] = 0;
                continue;
            }
            answer[i] = arr[i];
        }
        
        return answer;
    }
}