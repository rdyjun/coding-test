import java.util.*;

class Solution {
    private void rebatchCacheData (Queue<String> cacheData, String city) {
        int queueSize = cacheData.size();
        for (int i = 0; i < queueSize; i++) {
            String cacheCity = cacheData.poll();
            if (cacheCity.equals(city))
                continue;
            cacheData.add(cacheCity);
        }
        cacheData.add(city);
    }
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cacheData = new LinkedList<>();
        HashMap<String, Boolean> citiesStatus = new HashMap<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
            boolean cityInCached = citiesStatus.getOrDefault(city, false);
            if (cityInCached) {
                answer++;
                rebatchCacheData(cacheData, city);
                continue;
            }
            answer += 5;
            citiesStatus.put(city, true);
            cacheData.add(city);
            if (cacheData.size() > cacheSize) {
                String lastCity = cacheData.poll();
                citiesStatus.put(lastCity, false);
            }
        }
        return answer;
    }
}