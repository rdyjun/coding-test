class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1Col = arr1[0].length;
        int arr1Row = arr1.length;
        int arr2Col = arr2[0].length;
        int arr2Row = arr2.length;
        
        int[][] answer = new int[arr1Row][arr2Col];
        int col = 0;
        
        for (int i = 0; i < arr1Row; i++)
            for (int j = 0; j < arr2Col; j++) {
                for (int k = 0; k < arr1Col; k++)
                    answer[i][col % arr2Col] += arr1[i][k] * arr2[k][j];
                col++;
            }
        
        return answer;
    }
}   