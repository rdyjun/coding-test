import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr) {
        int min = -1;
        int max = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (min == -1 && arr[i] == 2)
                min = i;
            if (arr[i] == 2)
                max = i;
        }
        if (min == -1)
            return new int[]{-1};
        
        return IntStream.range(min, max + 1)
            .map(v -> arr[v])
            .toArray();
    }
}