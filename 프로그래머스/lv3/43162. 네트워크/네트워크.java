import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int[] arr = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int c = 1;
        int min = 0;
        
        while (min < n) {
            while (!q.isEmpty()) {
                int qValue = q.poll();
                arr[qValue] = c;
                for (int i = 0; i < n; i++)
                    if (computers[qValue][i] == 1 && arr[i] == 0)
                        q.add(i);
            }
            int tmp = -1;
            for (int i = min; i < n; i++)
                if (arr[i] == 0) {
                    tmp = i;
                    q.add(i);
                    break;
                }
            if (tmp == -1)
                return c;
            c++;
        }
        
        return 1;
    }
}