import java.util.Arrays;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startDay) {
        schedules = updateSchedulesByTen(schedules);
        startDay -= 1;
        
        int answer = schedules.length;
        
        for (int schedulesIndex = 0; schedulesIndex < timelogs.length; schedulesIndex++) {
            for (int dayIndex = 0; dayIndex < 7; dayIndex++) {
                int compareDate = (startDay + dayIndex) % 7;
                if (compareDate == 5 || compareDate == 6) {
                    continue;
                }
                
                if (timelogs[schedulesIndex][dayIndex] > schedules[schedulesIndex]) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private int[] updateSchedulesByTen(int[] schedules) {
        return Arrays.stream(schedules)
                .map(this::updateOneSchedule)
                .toArray();
    }
    
    private int updateOneSchedule(int schedule) {
        schedule += 10;
        if (schedule % 100 < 60) {
            return schedule;
        }
        
        return schedule + 40;
    }
}