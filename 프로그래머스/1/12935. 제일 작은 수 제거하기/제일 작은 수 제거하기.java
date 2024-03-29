class Solution {
    public int[] solution(int[] arr) {
        int l = arr.length;
        int p = 0;
        int[] answer;
        
        if(l <= 1){
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[l - 1];
            int m = arr[0];
            for(int i = 1; i < l; i++){
                if(arr[i] < m){
                    m = arr[i];
                }
            }
            for(int i = 0; i < l; i++){
                if(arr[i] != m){
                    answer[p] = arr[i];
                    p++;
                }
            }
        }
        return answer;
    }
}