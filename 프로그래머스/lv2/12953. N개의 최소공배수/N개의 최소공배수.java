class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int max = -1;
        for (int i = 0; i < arr.length; i++)
            if (max == -1 || max < arr[i])
                max = arr[i];
        boolean[] visited = new boolean[max];
        int n = 0;
        
        for (int i = 1; i < max; i++) {
            if (visited[i])
                continue;
            int[] tmp = arr.clone();
            for (int k = 0; k < arr.length; k++) {
                if (tmp[k] % (i + 1) == 0) {
                    tmp[k] /= i + 1;
                    n++;
                }
            }
            if (n >= 2) {
                arr = tmp.clone();
                answer *= i + 1;
                i--;
                n = 0;
                continue;
            }
            
            for (int k = i; k < max; k += (i + 1))
                visited[k] = true;
            n = 0;
        }
        for (int i : arr)
            answer *= i;
        return answer;
    }
}