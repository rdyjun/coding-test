class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIndex = 0;
        int stationNum = stations[stationIndex];
        for (int i = 1; i <= n; i++) {
            if (stationNum - w > i || stationNum + w < i) {
                answer++;
                i += w * 2;
                continue;
            }
            if (stationNum - w <= i) {
                i = stationNum + w;
                stationIndex++;
                if (stationIndex <= stations.length - 1)
                    stationNum = stations[stationIndex];
                continue;
            }
        }
        return answer;
    }
}