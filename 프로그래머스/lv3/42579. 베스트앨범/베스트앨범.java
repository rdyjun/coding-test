import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> totalPlays = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++)
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        
        List<Integer> answer = IntStream.range(0, genres.length)
            .boxed()
            .sorted((v1, v2) -> plays[v2] - plays[v1])
            .sorted((v1, v2) -> totalPlays.get(genres[v2]).compareTo(totalPlays.get(genres[v1])))
            .collect(Collectors.toList());
        
        Map<String, Long> genresLimit = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        
        for (Integer i : answer) {
            if (genresLimit.getOrDefault(genres[i], 0L) >= 2L)
                continue;
            genresLimit.put(genres[i], genresLimit.getOrDefault(genres[i], 0L) + 1);
            ans.add(i);
        }
        
        return ans.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}