import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int len = record.length;
        ArrayList<Integer> history = new ArrayList<>(); // 0 입장, 1 퇴장
        ArrayList<String> id = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String[] st = record[i].split(" ");
            if (st[0].equals("Change")) {
                user.put(st[1], st[2]);
                continue;
            }
            
            if (st[0].equals("Enter")) {
                if (!user.containsKey(st[1]) || !user.get(st[1]).equals(st[2]))
                    user.put(st[1], st[2]);
                history.add(0);
            }
            if (st[0].equals("Leave"))
                history.add(1);
            id.add(st[1]);
        }
        String[] answer = new String[history.size()];
        for (int i = 0; i < history.size(); i++)
            answer[i] = user.get(id.get(i)) + "님이 " + (history.get(i) == 0 ? "들어왔습니다." : "나갔습니다.");
        return answer;
    }
}