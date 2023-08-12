import java.util.*;
import java.lang.*;

class Solution {
    private static long answer = 0;
    
    private static City[] city;
    private static int cityCount;
    
    private static int needGold;
    private static int needSilver;
    
    private static long min;
    private static long max;
    
    // 정해진 시간 동안 모을 수 있는 자원이 필요한 자원을 보다 같거나 많은지 확인
    private void checkSendAllResuorce (int gold, int silver, int both, long mid) {
        if (this.needGold <= gold && this.needSilver <= silver && this.needGold + this.needSilver <= both) {
            this.answer = mid;
            return;
        }
    }
    
    // 정해진 시간을 가지고 모든 도시 순회
    private boolean travelsalCity (long mid, int cityCount) {
        int gold = 0;
        int silver = 0;
        int both = 0;
        
        for (int i = 0; i < cityCount && answer != mid; i++) {
            long maxTruckVisited = mid / city[i].getTime() / 2;
            maxTruckVisited += checkOneWayTravelsal(mid, city[i].getTime());
            
            gold += Math.min(city[i].getGold(), maxTruckVisited * city[i].getWeight());
            silver += Math.min(city[i].getSilver(), maxTruckVisited * city[i].getWeight());
            both += Math.min(city[i].getGold() + city[i].getSilver(), maxTruckVisited * city[i].getWeight());
            checkSendAllResuorce(gold, silver, both, mid);
        }
        if (answer == mid)
            return true;
        return false;
    }
    
    private int checkOneWayTravelsal (long maxTime, int oneWayTime) {
        if (maxTime % (oneWayTime * 2) >= oneWayTime)
            return 1;
        return 0;
    }
    
    // 최고 소요 시간 (a + b) / w * t * 2 == 10^9 * 2 / 1 * 10^5 * 2 
    private long maxRangeInitialize () {
        long maxTimeRange = 10;
        for (int i = 0; i < 13; i++)
            maxTimeRange *= 10;
        return maxTimeRange * 4;
    }
    
    // 최대, 최소 경로 업데이트
    private void updateCheckRange (long mid, boolean check) {
        if (check)
            this.max = mid - 1;
        if (!check)
            this.min = mid + 1;
    }
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        // 초기화
        this.cityCount = g.length;
        this.needGold = a;
        this.needSilver = b;
        this.city = new City[cityCount];
        
        // 각 도시별 객체 초기화
        for (int i = 0; i < cityCount; i++)
            this.city[i] = new City(g[i], s[i], w[i], t[i]);

        // 범위 지정
        this.max = maxRangeInitialize();
        this.min = 0;

        // 시간대별 이진 탐색
        while (min <= max) {
            long mid = (max + min) / 2;
            boolean tmp = travelsalCity(mid, cityCount);
            updateCheckRange(mid, tmp);
        }
        return answer;
    }
}

class City {
    private int gold;
    private int silver;
    private int weight;
    private int time;

    public City (int gold, int silver, int weight, int time) {
        this.gold = gold;
        this.silver = silver;
        this.weight = weight;
        this.time = time;
    }

    public int getGold () {
        return this.gold;
    }

    public int getSilver () {
        return this.silver;
    }

    public int getWeight () {
        return this.weight;
    }

    public int getTime () {
        return this.time;
    }
}
