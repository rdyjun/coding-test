import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int qSize = queue1.length;
        long a = 0;
        long b = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i : queue1) {
            a += i;
            q1.add(i);
        }
        for (int i : queue2) {
            b += i;
            q2.add(i);
        }

        int answer = 0;
        while (a != b && qSize * 3 > answer) {
            answer++;
            if (a > b) {
                int n = q1.poll();
                a -= n;
                b += n;
                q2.add(n);
                continue;
            }
            int n = q2.poll();
            a += n;
            b -= n;
            q1.add(n);
        }
        if (a != b)
            return -1;

        return answer;
    }
}