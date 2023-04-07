import java.util.*;

class Solution {
    public String solution(String s) {
        String[] answer = s.split("");
        ArrayList<String> a = new ArrayList<>();
        Arrays.sort(answer);
        
        if (answer.length > 1){
            for (int i = 0; i < s.length() - 1; i++) {
                if (answer[i].equals(answer[i + 1])) {
                    for(int k = i + 1; k < s.length(); k++) {
                        if (!answer[i].equals(answer[k])){
                            i = k - 1;
                            break;
                        }
                    }
                } else
                    a.add(answer[i]);
            }
            if (!(answer[answer.length - 1].equals(answer[answer.length - 2])))
                a.add(answer[answer.length - 1]);
            
            String ans = String.join("", a);
            return ans;
        } else if (answer.length == 1)
            return answer[0];
        else
            return "";
    }
}