import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int truckCount = truck_weights.length;
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();
        q.add(truck_weights[0]);
        count.add(0);
        int l = 1;
        
        int onBridgeWeight = truck_weights[0];
        for (; !count.isEmpty(); answer++) {
            if (count.peek() + bridge_length <= answer) {
                onBridgeWeight -= q.poll();
                count.poll();
            }
            if (l < truckCount && bridge_length >= q.size() && weight - onBridgeWeight >= truck_weights[l]) {
                q.add(truck_weights[l]);
                count.add(answer);
                onBridgeWeight += truck_weights[l];
                l++;
            }
        }
        
        return answer;
    }
}