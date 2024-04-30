import java.util.Arrays;

class Solution {
    private static final Integer LIMIT = 10000000;
    
    public int[] solution(long begin, long end) {
        int answerLength = (int) (end - begin + 1L); // 1 ~ 5001
        int[] answer = initializeArray(begin, end);
        
        int index;
        int root;
        
        for (long number = begin; number <= end; number++) {
            index = (int) (number - begin);
            int limit = (int) Math.min(LIMIT, Math.sqrt(number));
            
            for (int block = 2; block <= limit; block++) {
                if (number % block > 0L) {
                    continue;
                }
                
                int result = (int) (number / block);
                
                if (result > LIMIT ||
                   result < block) {
                    answer[index] = block;
                    continue;
                }
                
                answer[index] = result;
                break;
            }
        }
        
        return answer;
    }
    
    private int[] initializeArray(long begin, long end) {
        int size = (int) (end - begin + 1L);
        int[] array = new int[size];
        
        Arrays.fill(array, 1);
        
        if (begin == 1L) {
            array[0] = 0;
        }
        
        return array;
    }
}