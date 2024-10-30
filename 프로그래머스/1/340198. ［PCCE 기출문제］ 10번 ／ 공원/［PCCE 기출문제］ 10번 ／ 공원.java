import java.util.Arrays;

class Solution {
    private int[] mats;
    private String[][] park;
    
    public int solution(int[] mats, String[][] park) {        
        this.mats = mats;
        this.park = park;
        
        int answer = -1;
        int height = park.length;
        int width = park[0].length;
        
        for (int matIndex = 0; matIndex < mats.length; matIndex++) {
            if (answer >= mats[matIndex]) {
                continue;
            }
            
            if (validateArea(answer, mats[matIndex], height, width)) {
                answer = mats[matIndex];
            }
        }
        
        return answer;
    }
    
    private boolean validateArea(int answer, int mat, int height, int width) {
        for (int row = 0; row <= height - mat; row++) {
            for (int col = 0; col <= width - mat; col++) {
                if (!this.park[row][col].contains("-1")) {
                    continue;
                }

                if (isAvailable(row, col, mat)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isAvailable(int row, int col, int mat) {
        for (int areaRow = row; areaRow < row + mat; areaRow++) {
            for (int areaCol = col; areaCol < col + mat; areaCol++) {
                if (!this.park[areaRow][areaCol].contains("-1")) {
                    return false;
                }
            }
        }
        
        return true;
    }
}