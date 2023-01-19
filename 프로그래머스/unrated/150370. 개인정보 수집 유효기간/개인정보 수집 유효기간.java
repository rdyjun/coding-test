import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        int todayInt = Integer.parseInt(today.replaceAll("\\.", ""));
        int y, m, d;

        ArrayList<Integer> arr = new ArrayList<Integer>();


        for (int i = 0; i < privacies.length; i++) {
            y = Integer.parseInt(privacies[i].substring(0,4));
            m = Integer.parseInt(privacies[i].substring(5, 7));
            d = Integer.parseInt(privacies[i].substring(8, 10));
            for(int k = 0; k < terms.length; k++) {
                if(privacies[i].charAt(11) == terms[k].charAt(0)){
                    m += Integer.parseInt(terms[k].substring(terms[k].indexOf(" ") + 1));
                    y += (m - 1) / 12;
                    m = ((m - 1) % 12) + 1;

                    if(Integer.parseInt(y + (m < 10 ? "0" : "") + m + (d < 10 ? "0" : "") + d) <= todayInt) {
                        arr.add(i + 1);
                    }
                    break;
                }
            }
        }
        answer = new int[arr.size()];
        for(int i = 0 ; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}