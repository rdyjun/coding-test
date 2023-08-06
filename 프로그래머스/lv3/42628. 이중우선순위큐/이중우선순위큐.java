import java.util.*;

class Solution {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    PriorityQueue<Integer> reverseQ = new PriorityQueue<>(Comparator.reverseOrder());
    int num;
    public void delElement (String m) {
        if (m.equals("1")) {
            num = reverseQ.poll();
            q.remove(num);
        }
        if (m.equals("-1")) {
            num = q.poll();
            reverseQ.remove(num);
        }
    }
    
    public void calculate (String[] splitText) {
        if (splitText[0].equals("I")) {
            num = Integer.parseInt(splitText[1]);
            q.add(num);
            reverseQ.add(num);
            return;
        }
        if (!q.isEmpty())
            delElement(splitText[1]);
    }
    
    public int[] solution(String[] operations) {
        String[] splitText = new String[2];
        
        for (String st : operations) {
            splitText = st.split(" ");
            calculate(splitText);
        }
        int[] answer = new int[2];
        if (q.isEmpty())
            return new int[]{0, 0};
        answer[0] = reverseQ.poll();
        answer[1] = q.poll();
        
        return answer;
    }
}