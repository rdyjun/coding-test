class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSecond = convertTimeToSecond(video_len);
        int posSecond = convertTimeToSecond(pos);
        int opStartSecond = convertTimeToSecond(op_start);
        int opEndSecond = convertTimeToSecond(op_end);
        
        if (isOpening(posSecond, opStartSecond, opEndSecond)) {
            posSecond = opEndSecond;
        }
        
        for (String command : commands) {
            if (command.contains("next")) {
                posSecond += 10;
            }
            
            if (command.contains("prev")) {
                posSecond -= 10;
            }
            
            posSecond = Math.max(posSecond, 0);
            posSecond = Math.min(videoLenSecond, posSecond);
                    
            if (isOpening(posSecond, opStartSecond, opEndSecond)) {
                posSecond = opEndSecond;
            }
        }
        
        return convertSecondToTime(posSecond);
    }
    
    private int convertTimeToSecond(String time) {
        String[] timeSplit = time.split(":");
        return Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
    }
    
    private String convertSecondToTime(int time) {
        int minute = time / 60;
        return String.format("%02d", minute) + ":" + String.format("%02d", time % 60);
    }
    
    private boolean isOpening(int time, int startTime, int endTime) {
        return startTime <= time && endTime >= time;
    }
}