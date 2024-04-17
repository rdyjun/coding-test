import java.util.Arrays;

class Solution {
    
    private static final Integer TYPE_INDEX = 0;
    
    private static final Integer R1_INDEX = 1;
    
    private static final Integer C1_INDEX = 2;
    
    private static final Integer R2_INDEX = 3;
    
    private static final Integer C2_INDEX = 4;

    private static final Integer DEGREE_INDEX = 5;
    
    public int solution(int[][] board, int[][] skill) {
        int boardHeight = board.length;
        int boardWidth = board[0].length;
        
        int[][] prefixSumArray = getPrefixArray(boardHeight, boardWidth, skill);
        
        calculatePrefixSum(boardHeight, boardWidth, prefixSumArray);
        
        int answer = 0;
        
        for (int row = 0; row < boardHeight; row++) {
            for (int col = 0; col < boardWidth; col++) {
                if (prefixSumArray[row][col] + board[row][col] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void calculatePrefixSum(int height, int width, int[][] prefix) {
        for (int row = 0; row <= height; row++) {
            for (int col = 0; col <= width; col++) {
                int a = 0;
                int b = 0;
                int c = 0;
                
                if (row - 1 >= 0) {
                    a = prefix[row - 1][col];
                }
                
                if (col - 1 >= 0) {
                    b = prefix[row][col - 1];
                }
                
                if (row - 1 >= 0 && col - 1 >= 0) {
                    c = prefix[row - 1][col - 1];
                }
                
                prefix[row][col] += a + b - c;
            }
        }
    }
    
    private int[][] getPrefixArray(int height, int width, int[][] skill) {
        int[][] prefixSumArray = new int[height + 1][width + 1];
        
        int type, r1, c1, r2, c2, degree;
        
        for (int[] eachSkill : skill) {
            type = eachSkill[TYPE_INDEX];
            r1 = eachSkill[R1_INDEX];
            c1 = eachSkill[C1_INDEX];
            r2 = eachSkill[R2_INDEX];
            c2 = eachSkill[C2_INDEX];
            degree = eachSkill[DEGREE_INDEX];
            
            if (eachSkill[0] == 1) {
                degree *= -1;
            }
            
            prefixSumArray[r1][c1] += degree;
            prefixSumArray[r2 + 1][c1] -= degree;
            prefixSumArray[r1][c2 + 1] -= degree;
            prefixSumArray[r2 + 1][c2 + 1] += degree;
        }
        
        return prefixSumArray;
    }
    
}
