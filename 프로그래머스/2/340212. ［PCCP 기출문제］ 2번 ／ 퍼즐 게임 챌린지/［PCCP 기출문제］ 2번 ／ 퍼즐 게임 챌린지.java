import java.util.Arrays;

class Solution {
    private int[] diffs;
    private int[] times;
    private long limit;
    private int puzzleCount;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        this.puzzleCount = diffs.length;
        
        long minWeight = 1;
        long maxWeight = Arrays.stream(diffs).max().getAsInt();
        int answer = -1;

        while (minWeight <= maxWeight) {
            long middleWeight = (minWeight + maxWeight) / 2;
            long usedTime = calculateUsedTimeByWeight(middleWeight);
            
            if (usedTime > limit) {
                minWeight = middleWeight + 1;
                continue;
            }
            
            try {
                int convertToInt = Math.toIntExact(middleWeight);
                answer = convertToInt;
            } finally {
                maxWeight = middleWeight - 1;
            }
        }
        

        return answer;
    }
    
    public long calculateUsedTimeByWeight(long weight) {
        long usedTime = 0;
        
        for (int puzzleIndex = 0; puzzleIndex < this.puzzleCount; puzzleIndex++) {
            if (this.diffs[puzzleIndex] <= weight) {
                usedTime += this.times[puzzleIndex];
                continue;
            }

            long differentTime = diffs[puzzleIndex] - weight;
            long timePrev = 0;
            if (puzzleIndex - 1 >= 0) {
                timePrev = this.times[puzzleIndex - 1];
            }
            long rotateTime = timePrev + this.times[puzzleIndex];

            usedTime += rotateTime * differentTime + this.times[puzzleIndex];
            if (usedTime > this.limit) {
                return usedTime;
            }
        }
        
        return usedTime;
    }
}