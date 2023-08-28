import java.util.*;

class Solution {
    public int solution(String[] lines) {
        Arrays.sort(lines, Comparator.naturalOrder());
        
        
        int answer = 0;
        int tmp = 1;
        for (int i = 0; i < lines.length; i++) {
            tmp = 1;
            TimeLine mainTime = new TimeLine(lines[i]);
            for (int k = i + 1; k < lines.length; k++) {
                TimeLine compareTime = new TimeLine(lines[k]);
                if (!mainTime.compareTo(compareTime))
                    tmp--;
                tmp++;
            }
            if (answer < tmp) 
                answer = tmp;
        }
        
        return answer;
    }
}       

class TimeLine {
    private long time;
    private long during;
    
    public TimeLine (String time) {
        this.time = Long.parseLong(time.substring(17, 19)) * 1000;
        this.time += Long.parseLong(time.substring(20, 23));
        this.time += Long.parseLong(time.substring(14, 16)) * 60000;
        this.time += Long.parseLong(time.substring(11, 13)) * 60000 * 60;
        this.time += Long.parseLong(time.substring(8, 10)) * 60000 * 60 * 24;
        this.time += Long.parseLong(time.substring(5, 7)) * 60000 * 60 * 24 * 30;
        this.time += Long.parseLong(time.substring(0, 4)) * 60000 * 60 * 24 * 30 * 12;
        String st = time.substring(24, time.length() - 1);
        int index = st.length();
        if (st.contains("."))
            index = st.indexOf(".");
        
        this.during = Long.parseLong(st.substring(0, index)) * 1000L;
        long num = 1L;
        
        for (int i = 0; i < 3 - (st.length() - index - 1); i++)
            num *= 10;
        
        if (index + 1 < st.length())
            this.during += Long.parseLong(st.substring(index + 1, st.length())) * num;
    }
    
    public long getDuring () {
        return this.during;
    }
    
    public long getTimeRange (long plusSecond) {
        return this.time - plusSecond;
    }
    
    
    public boolean compareTo (TimeLine other) {
        long compareEndTime = this.getTimeRange(-999);
        
        long otherStartTime = other.getTimeRange(other.getDuring() - 1L);
        
        if (compareEndTime < otherStartTime)
            return false;
        
        return true;
    }
}