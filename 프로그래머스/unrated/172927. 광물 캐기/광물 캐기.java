import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int pc = picks[0] + picks[1] + picks[2];
        int mc;
        if (minerals.length % 5 == 0)
            mc = (minerals.length / 5);
        else
            mc = (minerals.length / 5) + 1;
        
        int[] arr = new int[pc > mc ? mc : pc];
        int answer = 0;
        
        for (int i = 0; i < arr.length && pc > 0; i++) {
            for (int k = i * 5; k < minerals.length && k < i * 5 + 5; k++) {
                String mr = minerals[k];
                arr[i] += mr.equals("diamond") ? 100 : mr.equals("iron") ? 10 : 1;
            }
            pc--;
        }
        
        Arrays.sort(arr);
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if(picks[0] > 0) {
                answer += (arr[i] / 100) + arr[i] % (100) / 10 + arr[i] % 10;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += (int)(arr[i] / 100) * 5;
                answer += (arr[i] % 100) / 10;
                answer += arr[i] % 10;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += (int)(arr[i] / 100) * 25;
                answer += (arr[i] % 100) / 10 * 5;
                answer += (arr[i] % 10);
                picks[2]--;
            } else
                break;
        }
        
        return answer;
    }
}