import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        ArrayList<Float> arr = new ArrayList<>();
        int n = dots.length;
        float a;
        for(int j = 1; j < n; j++){
            a = (float)(dots[0][0] - dots[j][0]) / (dots[0][1] - dots[j][1]);
            for(int k = 1; k < n - 1; k++){
                if(k == j){
                    continue;
                } else {
                    for(int o = k + 1; o < n; o++){
                        if(o == j){
                            continue;
                        } else {
                            if(a == (float)(dots[k][0] - dots[o][0]) / (dots[k][1] - dots[o][1])){
                                return 1;
                            }
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}