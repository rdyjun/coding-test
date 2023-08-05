import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        char[] answer = new char[t];
        Stack<Integer> number = new Stack<>();
        Character[] chr = new Character[]{'A', 'B', 'C', 'D', 'E', 'F'};
        int idx = 0;
        int tmp, stNum;
        int rotate = 0;
        for (int i = 0; idx < t; i++) {
            tmp = i;
            while(tmp >= n) {
                number.add(tmp % n);
                tmp = tmp / n;
            }
            number.add(tmp);

            while (!number.isEmpty()) {
                stNum = number.pop();
                if (idx >= t){
                    break;
                }
                if (rotate % m == p - 1) {
                    if (stNum < 10)
                        answer[idx] = String.valueOf(stNum).charAt(0);
                    if (stNum >= 10)
                        answer[idx] = chr[stNum - 10];
                    idx++;
                }
                rotate++;
            }
            number = new Stack<>();

        }
        return String.valueOf(answer);
    }
}