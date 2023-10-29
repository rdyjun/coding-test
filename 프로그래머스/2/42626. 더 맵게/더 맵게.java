import java.util.*;

class Solution {
    private int getMixValues (PriorityQueue<Integer> heapQueue) {
        return heapQueue.poll() + heapQueue.poll() * 2;
    }
    private PriorityQueue<Integer> getHeapQueue (int[] scoville) {
        PriorityQueue<Integer> heapQueue = new PriorityQueue<>();
        for (int sc : scoville)
            heapQueue.add(sc);
        return heapQueue;
    }
    private int getMin (PriorityQueue<Integer> heapQueue) {
        int min = heapQueue.poll();
        heapQueue.add(min);
        return min;
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heapQueue = getHeapQueue(scoville);
        int min = getMin(heapQueue);
        while (heapQueue.size() > 1 && min < K) {
            answer++;
            heapQueue.add(getMixValues(heapQueue));
            min = getMin(heapQueue);
        }
        if (heapQueue.poll() < K)
            return -1;
        return answer;
    }
}