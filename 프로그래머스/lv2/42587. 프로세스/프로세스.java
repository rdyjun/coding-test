import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i : priorities)
            num.add(i);
        Collections.sort(num); // 1 2 2 3 정렬
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> arr = new LinkedList<>();
        
        for (int i : priorities)
            q.add(i);
        for (int i = 0; i < q.size(); i++)
            arr.add(i);
            
        int c = 0;
        
        while (!q.isEmpty()) {
            int qdata = q.poll();
            if(num.get(q.size()) > qdata) {
                q.add(qdata);
                arr.add(arr.poll());
                continue;
            }
            c++;
            if (arr.poll() == location)
                return c;
        }
        return -1;
    }
}