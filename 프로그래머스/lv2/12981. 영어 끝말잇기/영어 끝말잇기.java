import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> st = new ArrayList<>();
        st.add(words[0]);
        for (int i = 0; i < words.length - 1; i++) {
            if (st.contains(words[i + 1]))
                return new int[]{(i + 1) % n + 1, (int)((i + 1) / n) + 1};
            char nowChar = words[i].charAt(words[i].length() - 1);
            char nextChar = words[i + 1].charAt(0);
            if (nowChar != nextChar)
                return new int[]{(i + 1) % n + 1, (int)((i + 1) / n) + 1};
            st.add(words[i + 1]);
        }

        return new int[]{0, 0};
    }
}