class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        boolean isFirst = true;
        int startTime = (h1 * 60 * 60) + (m1 * 60) + s1;
        int endTime = (h2 * 60 * 60) + (m2 * 60) + s2;
        int answer = 0;
        
        double prevHourAngle = -1.0;
        double prevMinuteAngle = -1.0;
        
        for (int time = startTime; time <= endTime; time++) {
            int hour = time / 3600;
            int minute = (time / 60) % 60;
            int second = time % 60;
            
            double hourAngle = (hour % 12 * 5) + (minute / 60.0 * 5) + (second / 3600.0);
            double minuteAngle = minute + (second / 60.0);
            boolean isHourColliderect = checkColliderect(hourAngle, prevHourAngle, second);
            boolean isMinuteColliderect = checkColliderect(minuteAngle, prevMinuteAngle, second);
            
            if (hourAngle == second || minuteAngle == second) {
                answer++;
            }
            
            if (isHourColliderect) {
                answer++;
            }
            if (isMinuteColliderect) {
                answer++;
            }
            
            prevHourAngle = hourAngle;
            prevMinuteAngle = minuteAngle;
        }
        
        return answer;
    }
    
    private boolean checkColliderect(double targetAngle, double prevAngle, int second) {
        int prevSecond = (second - 1 + 60) % 60;
        if (second == 0) {
            second = 60;
            if (targetAngle >= 0 && targetAngle < 1) {
                targetAngle += 60;
            }
        }
        
        if (prevAngle > prevSecond && targetAngle < second) {
            return true;
        }
        
        return false;
    }
}