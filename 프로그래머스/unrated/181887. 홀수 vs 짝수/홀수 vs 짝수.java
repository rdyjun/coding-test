import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        return Integer.max(IntStream.iterate(0, i -> i < num_list.length, i -> i + 2)
                          .map(v -> num_list[v])
                          .sum(),
                          IntStream.iterate(1, i -> i < num_list.length, i -> i + 2)
                          .map(v -> num_list[v])
                          .sum());
    }
}