class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] i : queries)
            for (int k = i[0]; k <= i[1]; k++)
                arr[k]++;
        
        return arr;
    }
}