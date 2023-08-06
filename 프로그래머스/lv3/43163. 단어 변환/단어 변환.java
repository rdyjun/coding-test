import java.util.*;

class Solution {   
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        for (int i = 0; i < visited.length; i++)
            visited[i] = true;
        
        Queue<String> q = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        
        int n = 0;
        int count;
        String st;
        q.add(begin);
        c.add(0);
        
        while (!q.isEmpty()) {
            begin = q.poll();
            count = c.poll();
            if (begin.equals(target))
                return count;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    st = words[i];
                    for (int k = 0; k < st.length() && n < 2; k++) {
                        if (st.charAt(k) != begin.charAt(k))
                            n++;
                    }
                    if (n == 1) {
                        q.add(st);
                        c.add(count + 1);
                        visited[i] = false;
                    }
                    n = 0;
                }
            }
        }
        return 0;
    }
}