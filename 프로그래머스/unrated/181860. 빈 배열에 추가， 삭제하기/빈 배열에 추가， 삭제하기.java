import java.util.Stack;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int k = 0; k < arr[i] * 2; k++)
                    stack.add(arr[i]);
                continue;
            }
            for (int k = 0; k < arr[i]; k++)
                stack.pop();
        }
        return stack.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}