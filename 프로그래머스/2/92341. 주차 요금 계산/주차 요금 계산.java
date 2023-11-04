import java.util.*;

class Solution {
    private boolean isIn (String record) {
        if (record.contains("IN"))
            return true;
        return false;
    }
    private String getCarNumber (String record) {
        return record.substring(6, 10);
    }
    private int getTime (String record) {
        String stringTime = record.substring(0, 2);
        int time = Integer.parseInt(stringTime) * 60;
        stringTime = record.substring(3, 5);
        time += Integer.parseInt(stringTime);
        return time;
    }
    private int getMoney (int time, int[] fees) {
        if (time <= fees[0])
            return fees[1];
        
        int moreTime = (time - fees[0]) / fees[2];
        if ((time - fees[0]) % fees[2] != 0)
            moreTime++;
        moreTime *= fees[3];
        return fees[1] + moreTime;
    }
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> usingTime = new HashMap<>();
        for (String record : records) {
            String carNumber = getCarNumber(record);
            int time = getTime(record);
            if (isIn(record)) {
                inMap.put(carNumber, time);
                continue;
            }
            usingTime.put(carNumber, usingTime.getOrDefault(carNumber, 0) + (time - inMap.get(carNumber)));
            inMap.remove(carNumber);
        }
        /* 출차하지 않은 차량들 출차 처리 */
        for (String car : inMap.keySet())
            usingTime.put(car, usingTime.getOrDefault(car, 0) + (1439 - inMap.get(car)));
        
        int[] answer = new int[usingTime.size()];
        List<String> keyName = new ArrayList<>(usingTime.keySet());
        Collections.sort(keyName);
        for (int i = 0; i < keyName.size(); i++)
            answer[i] = getMoney(usingTime.get(keyName.get(i)), fees);
            
        return answer;
    }
}