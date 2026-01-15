import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 다리 위 무게
        int currentWeight = 0;
        
        // 다리 위 트럭 큐
        Queue<Integer> onBridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            onBridge.add(0);
        }
        
        // 대기중인 트럭 큐
        Queue<Integer> waiting = new LinkedList<>();
        Arrays.stream(truck_weights)
                .forEach((w) -> waiting.add(w));
        
        // 대기중인 트럭이 없는 경우 종료
        while (!waiting.isEmpty()) {
            
            // 시간 흐름
            answer++;
            
            // 다리 위 트럭 내림
            currentWeight -= onBridge.poll();
            
            // 다음 트럭 다리 못 올라감 0 넣기
            if (currentWeight + waiting.peek() > weight) {
                onBridge.add(0);
                
                continue;
            }
            
            // 다음 트럭 다리 올라감
            int now = waiting.poll();
            currentWeight += now;
            onBridge.add(now);
        }
        
        int temp = 0;
        int diff = 0;
        
        while (!onBridge.isEmpty()) {
            temp++;
            int w = onBridge.poll();
            if (w > 0) {
                diff = temp;
            }
        }
        
        return answer + diff;
    }
}
