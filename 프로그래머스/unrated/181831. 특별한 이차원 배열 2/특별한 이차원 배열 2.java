class Solution {
    public int solution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr.length - i; k++) {
                if (arr[i][k] != arr[k][i])
                    return 0;
            }
        }
        return 1;
    }
}