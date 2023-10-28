import java.util.*;

class Solution {
    private int col;
    private int row;
    
    private int[] getTwoMax (int[] values) {
        int valuesLength = values.length;
        Arrays.sort(values);
        return new int[]{values[valuesLength - 1], values[valuesLength - 2]};
    }
    private void setMaxValues (int[][] land, int[] maxValues, int row) {
        for (int index = 0; index < this.col; index++) {
            if (maxValues[0] == land[row][index]) {
                land[row + 1][index] += maxValues[1];
                continue;
            }
            land[row + 1][index] += maxValues[0];
        }
    }
    public int solution(int[][] land) {
        this.col = land[0].length;
        this.row = land.length;
        
        for (int i = 0; i < row - 1; i++) {
            int[] maxValues = getTwoMax(land[i].clone());
            setMaxValues(land, maxValues, i);
        }
        return getTwoMax(land[row - 1])[0];
    }
}