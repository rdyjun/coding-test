import java.util.*;

class Solution {
    private int[] getTwoMax (int[] values) {
        Arrays.sort(values);
        return new int[]{values[values.length - 1], values[values.length - 2]};
    }
    public int solution(int[][] land) {
        int col = land[0].length;
        int row = land.length;
        
        for (int i = 0; i < row - 1; i++) {
            int[] max = getTwoMax(land[i].clone());
            for (int k = 0; k < col; k++) {
                if (max[0] == land[i][k]) {
                    land[i + 1][k] += max[1];
                    continue;
                }
                land[i + 1][k] += max[0];
            }
        }
        return getTwoMax(land[row - 1])[0];
    }
}