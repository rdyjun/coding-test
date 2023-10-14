import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch (n) {
            case 1:
                return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
            case 2:
                return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
            case 3:
                return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
            case 4:
                return IntStream.range(slicer[0], slicer[1] + 1)
                    .filter(v -> (v - slicer[0]) % slicer[2] == 0)
                    .map(v -> num_list[v])
                    .toArray();
        }
        return new int[1];
    }
}