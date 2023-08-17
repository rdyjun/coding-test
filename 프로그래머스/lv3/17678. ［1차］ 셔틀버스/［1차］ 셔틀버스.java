import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int hour = 9;
        int minute = 0;
        
        String[] crewList = Arrays.asList(timetable)
            .stream()
            .sorted()
            .toArray(String[]::new);
        
        List<Integer> bus = new ArrayList<>();
        
        int crewIndex = 0;
        int crewAtBus = 0;
        int crewHour;
        int crewMinute;
        int busCount = 0;
        
        List<Crew> lastBusTime = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            busCount++;
            int nowBusSeat = crewIndex + m - 1;
            for (; crewIndex < crewList.length && crewIndex <= nowBusSeat; crewIndex++) {
                String crewTime = crewList[crewIndex];
                crewHour = Integer.parseInt(crewTime.substring(0, 2));
                crewMinute = Integer.parseInt(crewTime.substring(3, 5));
                
                if (crewHour > hour ||
                   (crewHour == hour && crewMinute > minute)) {
                    break;
                }
                    
                if (busCount == n) {
                    Crew crew = new Crew(crewHour, crewMinute);
                    lastBusTime.add(crew);
                }
            }
            minute += t;
            hour += minute / 60;
            minute %= 60;
        }
        
        minute -= t;
        if (minute < 0) {
            hour -= (minute / 60 * -1) + (minute % 60 > 0 ? 1 : 0);
            minute = 60 + minute;
        }
        
        
        if (lastBusTime.size() == m)
            return lastBusTime.get(lastBusTime.size() - 1).getFastTime();
        
        return String.format("%02d:%02d", hour, minute);
    }
}

class Crew {
    private int hour;
    private int minute;
    
    public Crew (int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    
    public String getTime () {
        return String.format("%02d:%02d", this.hour, this.minute);
    }
    public String getFastTime () {
        this.minute -= 1;
        if (this.minute < 0) {
            this.hour -= 1;
            this.minute = 59;
        }
        return String.format("%02d:%02d", this.hour, this.minute);
    }
}