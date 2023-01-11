package programmers;

import java.util.ArrayList;

public class 하노이의탑 {
    static class Solution {
        ArrayList<int[]> ans = new ArrayList<>();
        public void hanoi (int n, int now, int next, int other) {
            int[] mv = new int []{now, next};

            if (n == 1){
                ans.add(mv);
            } else {
                hanoi(n - 1, now, other, next);
                ans.add(mv);
                hanoi(n - 1, other, next, now);
            }
        }

        public int[][] solution(int n) {
            hanoi(n, 1, 3, 2);
            int[][] answer = new int[ans.size()][2];

            for(int i = 0; i < ans.size(); i++){
                answer[i] = ans.get(i);
            }

            for(int i = 0; i < answer.length; i++) {
                for(int k = 0; k < 2; k++){
                    System.out.print(answer[i][k]);
                }
                System.out.println();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.solution(2);
        s.solution(4);
    }
}
