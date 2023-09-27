class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        int[] answer = new int[len];
        
        int floor = (int)(left / n);
        int startIdx = (int)(left % n);
        
        System.out.println(startIdx);
        
        for (int i = 0; i < len; i++) {
            if (startIdx <= floor)
                answer[i] = floor + 1;
            else
                answer[i] = startIdx + 1;
            
            startIdx++;
            startIdx %= n;
            if (startIdx == 0)
                floor++;
        }
        
        return answer;
    }
}