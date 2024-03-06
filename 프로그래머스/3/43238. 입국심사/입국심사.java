class Solution {
    public long solution(int n, int[] times) {
        int timesLength = times.length;
        long min = 0;
        long max = -1;
        long mid;
        long sum;
        
        for (int i = 0; i < timesLength; i++) {
            if (max == -1 || max < times[i]) {
                max = times[i];
            }
        }
        
        max *= n;
        
        while (min <= max) {
            sum = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < timesLength; i++) {
                sum += mid / times[i];
            }
            
            if (sum >= n){
                max = mid - 1;
                continue;
            }
            
            min = mid + 1;
        }
        
        return min;
    }
}