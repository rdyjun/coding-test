import java.util.*;

class Solution {
    public boolean isOutOfMap (int[] pos, int[][] maps) {
        if (pos[0] >= maps.length)
            return true;
        if (pos[1] >= maps[0].length)
            return true;
        if (pos[0] < 0)
            return true;
        if (pos[1] < 0)
            return true;
        return false;
    }
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        q.add(new int[]{0, 0});
        c.add(1);
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int count = c.poll();
            
            if (isOutOfMap(pos, maps) || maps[pos[0]][pos[1]] == 0)
                continue;
            maps[pos[0]][pos[1]] = 0;
            
            if (pos[0] == maps.length - 1 && pos[1] == maps[0].length - 1)
                return count;
            
            for (int[] eachDir : dir) {
                q.add(new int[]{pos[0] + eachDir[0], pos[1] + eachDir[1]});
                c.add(count + 1);
            }
        }
        return -1;
    }
}