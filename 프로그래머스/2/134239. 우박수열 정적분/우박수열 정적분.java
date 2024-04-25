import java.util.List;
import java.util.ArrayList;

class Solution {
    private static final Integer START_RANGE_INDEX = 0;
    private static final Integer END_RANGE_INDEX = 1;
    
    public double[] solution(int k, int[][] ranges) {
        List<Integer> arr = new ArrayList<>();
        
        while (k > 1) {
            arr.add(k);
            
            if (k % 2 == 0) {
                k /= 2;
                continue;
            }
            
            k *= 3;
            k++;
        }
        
        arr.add(1);
        
        double[] square = new double[arr.size() - 1];
        
        for (int i = 0; i < arr.size() - 1; i++) {
            int num1 = arr.get(i);
            int num2 = arr.get(i + 1);
            int max = Math.max(num1, num2);
            int min = Math.min(num1, num2);
            
            square[i] = (max - min) / 2.0 + min;
        }
        
        int rangeLength = ranges.length;
        double[] answer = new double[rangeLength];
        
        for (int i = 0; i < rangeLength; i++) {
            int left = ranges[i][START_RANGE_INDEX];
            int right = arr.size() - 1 + ranges[i][END_RANGE_INDEX];
            
            answer[i] = sum(left, right, square);
        }
        
        return answer;
    }
    
    private double sum(int start, int end, double[] square) {
        if (start > end) {
            return -1.0;
        }
        
        double sum = 0.0;
        for (int i = start; i < end; i++) {
            sum += square[i];
        }
        
        return sum;
    }
}
