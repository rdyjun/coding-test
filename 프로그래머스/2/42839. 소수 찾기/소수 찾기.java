import java.lang.Math;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private int maxCount;
    private String[] arr;
    private static Set<Integer> s = new HashSet<>();
    private static int answer = 0;
    public void dfs (int count, StringBuilder stb, boolean[] visited) {
        if (!stb.toString().equals("")) {
            int num = Integer.parseInt(stb.toString());
            if (!s.contains(num)) {
                answer += isPrime(num);
                s.add(num);
            }
            if (count >= maxCount)
                return;
        }
        
        
        for (int i = 0; i < maxCount; i++) {
            if (visited[i])
                continue;
            StringBuilder tmpStb = new StringBuilder(stb);
            boolean[] tmpVisited = visited.clone();
            tmpStb.append(arr[i]);
            tmpVisited[i] = true;
            dfs(count + 1, tmpStb, tmpVisited);
        }
    }
    public int solution(String numbers) {
        maxCount = numbers.length();
        arr = numbers.split("");
        dfs(0, new StringBuilder(), new boolean[maxCount].clone());
        return answer;
    }
    private int isPrime (int n) {
        if (n <= 1)
            return 0;
        int x = (int) Math.sqrt(n);
        boolean[] visited = new boolean[x + 1];
        for (int i = 2; i <= x; i++) {
            if (visited[i])
                continue;
            if (n % i == 0)
                return 0;
            for (int k = 1; k * i <= x; k++)
                visited[k * i] = true;
        }
        return 1;
    }
}