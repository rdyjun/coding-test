import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        int num = 0;
        int num2 = -1;
        int[] answer;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                num += 1;
            }
        }
        answer = new int[num];
        
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        for(int i = 0; i < num; i++){
            for(int k = 0 + (num2 == -1 ? 0 : (num2) + 1); k < arr.length; k++){
                if(arr[k] % divisor == 0){
                    answer[i] = arr[k];
                    num2 = k;
                    break;
                }
            }
        }
        
        
        
        return answer;
    }
}