import java.util.*;

class Solution {
    int[] answer = new int[2];
    boolean flags;
    int[][] nrr;
    int[] square;
    int len;
    public void addValue (int num) {
        if (num != -1)
            answer[num]++;
    }
        
    public boolean compare (int row, int col) {
        if (square[0] == square[1]
            && square[1] == square[2]
            && square[2] == square[3]) {
            nrr[row / 2 ][col / 2] = square[0];
            return true;
        }
        for (int j = 0; j < 4; j++)
            addValue(square[j]);
        nrr[row / 2][col / 2] = -1;
        return false;
    }
    
    public void rotateArray (int i, int[][] arr) {
        for (int k = 0; k < len; k += 2) {
            square = new int[]{arr[i][k], arr[i + 1][k], arr[i][k + 1], arr[i + 1][k + 1]};
            flags = compare(i, k) || flags;
        }
    }
    public void recursion (int[][] arr) {
        flags = false;
        len = arr.length;
        if (len == 1) {
            if (arr[0][0] != -1)
                answer[arr[0][0]]++;
            return;
        }
        nrr = new int[len / 2][len / 2];
        for (int i = 0; i < len; i += 2)
            rotateArray(i, arr);
            
        
        if (flags)
            recursion(Arrays.copyOf(nrr, nrr.length));
    }
    
    public int[] solution(int[][] arr) {
        recursion(arr);
        return answer;
    }
}