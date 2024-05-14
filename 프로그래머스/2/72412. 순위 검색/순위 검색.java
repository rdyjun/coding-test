import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    
    private static final Integer COLUMN_COUNT = 5;
    
    private Map<String, List<Integer>> infoMap;
    
    private Integer infoCount;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        this.infoCount = info.length;
        this.infoMap = new HashMap<>();
        
        for (int i = 0; i < info.length; i++) {
            String[] splitInfo = info[i].split(" ");
            int score = Integer.parseInt(splitInfo[4]);
            dfs(-1, "", splitInfo, score);
        }
        
        for (int i = 0; i < query.length; i++) {
            String[] querySplit = Arrays.stream(
            query[i].split(" "))
                .filter(value -> !value.equals("and"))
                .map(String::trim)
                .toArray(String[]::new);
            
            int score = Integer.parseInt(querySplit[COLUMN_COUNT - 1]);
            querySplit[COLUMN_COUNT - 1] = "";
            String key = String.join("", querySplit);
            
            List<Integer> scoreList = this.infoMap.getOrDefault(key, new ArrayList<>());
            if (scoreList.size() == 0) {
                continue;
            }
            
            answer[i] = scoreList.size() - binarySearch(scoreList, score) - 1;
        }
        
        return answer;
    }
    
    private void dfs(int index, String word, String[] info, int score) {
        if (index == COLUMN_COUNT - 2) {
            putScore(word, score);
            return;
        }
        
        dfs(index + 1, word + info[index + 1], info, score);
        dfs(index + 1, word + "-", info, score);
    }
    
    private void putScore(String word, int score) {
        List<Integer> scoreList = this.infoMap.getOrDefault(word, new ArrayList<>());
        
        scoreList.add(binarySearch(scoreList, score) + 1, score);
        
        this.infoMap.put(word, scoreList);
    }
    
    private int binarySearch(List<Integer> arr, int searchValue) {
        int left = 0;
        int right = arr.size() - 1;
        int result = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr.get(mid) >= searchValue) {
                result = mid - 1;
                right = mid - 1;
                continue;
            }
            
            left = mid + 1;
        }
        
        return result;
    }
    
}