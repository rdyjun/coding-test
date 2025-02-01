class Solution {    
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = convertToSeconds(play_time);
        int advTime = convertToSeconds(adv_time);
        if (playTime == advTime) {
            return "00:00:00";
        }

        int[] timeline = initTimeline(playTime, advTime, logs);
        int answer = getUserCountByTimeline(playTime, advTime, timeline);
        
        return secondToTime(answer);
    }
    
    /** 배열을 순회하며 최적 값 탐색 */
    private int getUserCountByTimeline(int playTime, int advTime, int[] timeline) {
        long maxCount = 0;
        int startTimeByMaxCount = 0;
        
        for (int time = 0; time < advTime; time++) {
            maxCount += timeline[time];
        }
        
        long currentCount = maxCount;
        
        // adv_time 만큼 시간을 계산하고 1초씩 이동하여 맨 초의 값을 제거하고 뒤 초의 값을 추가하여 검증
        for (int time = advTime; time <= playTime; time++) {
            currentCount += timeline[time] - timeline[time - advTime];
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
                startTimeByMaxCount = time - advTime + 1;
            }
        }
        
        return startTimeByMaxCount;
    }
    
    private int[] initTimeline(int playTime, int advTime, String[] logs) {
        int[] timeline = new int[playTime + 1];
        
        // 누적합 적용
        for (String log : logs) {
            String[] splitLog = log.split("-");
            int startSecond = convertToSeconds(splitLog[0]);
            int endSecond = convertToSeconds(splitLog[1]);
            
            timeline[startSecond]++;
            timeline[endSecond]--;
        }
        
        // 누적합 결과 각 배열에 합산
        for (int i = 1; i <= playTime; i++) {
            timeline[i] += timeline[i - 1];
        }
        
        return timeline;
    }
    
    // 3661 -> 01:01:01 변환
    private String secondToTime(int time) {
        int hour = time / 60 / 60;
        int minute = (time / 60) % 60;
        int second = time % 60;
        
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    // 01:01:01 -> 3661 변환
    private int convertToSeconds(String time) {
        String[] splitTime = time.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);
        int second = Integer.parseInt(splitTime[2]);
        
        return (hour * 60 * 60)
                + (minute * 60)
                + second;
    }
}