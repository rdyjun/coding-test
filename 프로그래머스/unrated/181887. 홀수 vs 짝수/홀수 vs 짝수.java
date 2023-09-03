import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        int even = IntStream.range(0, num_list.length)
            .filter(v -> v % 2 == 0)
            .map(v -> num_list[v])
            .sum();
        int odd = IntStream.range(0, num_list.length)
            .filter(v -> v % 2 != 0)
            .map(v -> num_list[v])
            .sum();
        
        return even > odd ? even : odd;
    }
}