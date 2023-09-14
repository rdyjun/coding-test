import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            int lastValue = stack.pop();
            if (lastValue != arr[i]) {
                stack.push(lastValue);
                stack.push(arr[i]);                
            }
        }
        if (stack.isEmpty())
            stack.push(-1);
        
        return stack.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}